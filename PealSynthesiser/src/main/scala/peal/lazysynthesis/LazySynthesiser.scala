package peal.lazysynthesis

import scala.collection.JavaConversions._
import peal.domain.operator.{Max, Min, Mul, Plus}
import peal.domain._
import peal.synthesis._
import peal.antlr.util.ParserHelper
import peal.domain.BasicPolicySet
import peal.synthesis.GreaterThanThCondition
import peal.synthesis.LessThanThCondition
import peal.domain.MinPolicySet
import peal.domain.MaxPolicySet
import peal.domain.Pol

class LazySynthesiser(input: String) {

  val pealProgramParser = ParserHelper.getPealParser(input)
  pealProgramParser.program()

  //TODO need to support synthesis of predicate replacement

  val pols = pealProgramParser.pols
  val conds = pealProgramParser.conds
  val pSets = pealProgramParser.pSets
  val allRules = pealProgramParser.pols.values().flatMap(pol => pol.rules)
  val predicateNames = allRules.map(r => r.q.name).toSet
  val nonConstantDefaultScores = pols.foldLeft(Set[String]())((acc, tuple) => {
    tuple._2 match {
      case p: Pol =>
        def addVariables(set: Set[String]) = p.score.fold(score => set, variable => set + variable.name)
        addVariables(acc)
      case _ => acc
    }
  })
  val nonConstantScores = allRules.foldLeft(Set[String]())((acc, rule) => {
    def addVariables(set: Set[String]) = rule.attribute.fold(score => set, variable => set + variable.name)
    addVariables(acc)
  })
  val analyses = pealProgramParser.analyses.toMap

  private def findAllPolicySets(policySet: PolicySet): Set[String] = policySet match {
    case s: BasicPolicySet => Set(s.pol.asInstanceOf[Pol].name)
    case s: MaxPolicySet => findAllPolicySets(s.lhs) ++ findAllPolicySets(s.rhs)
    case s: MinPolicySet => findAllPolicySets(s.lhs) ++ findAllPolicySets(s.rhs)
    case _ => Set()
  }

  private def generateConditionEnforcement(condName: String, bName: String): String = {
    val buffer = new StringBuilder
    pols(bName).operator match {
      case Min =>
        val genFormula = conds(condName) match {
          case cond: LessThanThCondition =>
            val filtered = pols(bName).rules.filter(_.score <= cond.getTh)
            if (filtered.size > 0) {
              "(or (and (<= " + pols(bName).scoreString + " " + cond.getTh + ") (not (or " + pols(bName).rules.map(_.q.name).mkString(" ") + ")))\n" +
                "(or " + filtered.map(_.q.name).mkString(" ") + ")))"
            }
            else {
              "(or (and (<= " + pols(bName).scoreString + " " + cond.getTh + ") (not (or " + pols(bName).rules.map(_.q.name).mkString(" ") + ")))\n" +
                "false))"

            }
          case cond: GreaterThanThCondition =>
            val filtered = pols(bName).rules.filter(_.score <= cond.getTh)
            if (filtered.size > 0) {
              "(or (and (< " + cond.getTh + " " + pols(bName).scoreString + ") (not (or " + pols(bName).rules.map(_.q.name).mkString(" ") + ")))\n" +
                "(and (or " + pols(bName).rules.map(_.q.name).mkString(" ") + ") " + "(not (or " + filtered.map(_.q.name).mkString(" ") + ")))))"
            }
            else {
              "(or (and (< " + cond.getTh + " " + pols(bName).scoreString + ") (not (or " + pols(bName).rules.map(_.q.name).mkString(" ") + ")))\n" +
                "(and (or " + pols(bName).rules.map(_.q.name).mkString(" ") + ") " + "(not false))))"
            }
        }
        buffer.append("(assert (= " + condName + "_" + bName + " " + genFormula + ")\n")
      case Max =>
        val genFormula = conds(condName) match {
          case cond: LessThanThCondition =>
            val filtered = pols(bName).rules.filter(_.score <= cond.getTh)
            if (filtered.size > 0) {
              "(or (and (<= " + pols(bName).scoreString + " " + cond.getTh + ") (not (or " + pols(bName).rules.map(_.q.name).mkString(" ") + ")))\n" +
                "(and (or " + pols(bName).rules.map(_.q.name).mkString(" ") + ") " + "(not (or " + pols(bName).rules.filter(_.score <= cond.getTh).map(_.q.name).mkString(" ") + ")))))"
            }
            else {
              "(or (and (<= " + pols(bName).scoreString + " " + cond.getTh + ") (not (or " + pols(bName).rules.map(_.q.name).mkString(" ") + ")))\n" +
                "(and (or " + pols(bName).rules.map(_.q.name).mkString(" ") + ") " + "(not false))))"
            }
          case cond: GreaterThanThCondition =>
            val filtered = pols(bName).rules.filter(cond.getTh < _.score)
            if (filtered.size > 0) {
              "(or (and (< " + cond.getTh + " " + pols(bName).scoreString + ") (not (or " + pols(bName).rules.map(_.q.name).mkString(" ") + ")))\n" +
                "(or " + filtered.map(_.q.name).mkString(" ") + ")))"
            }
            else {
              "(or (and (< " + cond.getTh + " " + pols(bName).scoreString + ") (not (or " + pols(bName).rules.map(_.q.name).mkString(" ") + ")))\n" +
                "false))"
            }
        }
        buffer.append("(assert (= " + condName + "_" + bName + " " + genFormula + ")\n")
      case o =>
        conds(condName) match {
          case cond: GreaterThanThCondition =>
            buffer.append("(assert (= " + condName + "_" + bName +
              " (or (and (< " + cond.th + " " + pols(bName).scoreString + ") (not (or " + pols(bName).rules.map(_.q.name).mkString(" ") + "))) " +
              " (and (or " + pols(bName).rules.map(_.q.name).mkString(" ") + ") " +
              " (< " + cond.th + " (" + o + " " + pols(bName).rules.map(bName + "_score_" + _.q.name).mkString(" ") + "))))))\n")
          case cond: LessThanThCondition =>
            buffer.append("(assert (= " + condName + "_" + bName +
              " (or (and (<= " + pols(bName).scoreString + " " + cond.th + ") (not (or " + pols(bName).rules.map(_.q.name).mkString(" ") + "))) " +
              " (and (or " + pols(bName).rules.map(_.q.name).mkString(" ") + ") " +
              " (<= (" + o + " " + pols(bName).rules.map(bName + "_score_" + _.q.name).mkString(" ") + ") " + cond.th + ")))))\n")
        }
    }
    buffer.toString()
  }

  private def generatePolicySetAssertions(condName: String): String = {
    val buffer = new StringBuilder
    conds(condName) match {
      case s: GreaterThanThCondition => buffer.append("(assert (= " + condName + " " + genPSA("<", s.getPol) + "))\n")
      case s: LessThanThCondition => buffer.append("(assert (= " + condName + " " + genPSA("<=", s.getPol) + "))\n")
      case s: NotCondition => buffer.append("(assert (= " + condName + " " + s.synthesis(null) + "))\n")
      case s: ConjunctionCondition => buffer.append("(assert (= " + condName + " " + s.synthesis(null) + "))\n")
      case s: DisjunctionCondition => buffer.append("(assert (= " + condName + " " + s.synthesis(null) + "))\n")
      case s: TrueCondition => buffer.append("(assert (= " + condName + " " + s.synthesis(null) + "))\n")
      case s: FalseCondition => buffer.append("(assert (= " + condName + " " + s.synthesis(null) + "))\n")
    }

    def genPSA(operator: String, pSet: PolicySet): String = operator match {
      case "<" =>
        pSet match {
          case s: MaxPolicySet => "(or " + genPSA(operator, s.lhs) + " " + genPSA(operator, s.rhs) + ")"
          case s: MinPolicySet => "(and " + genPSA(operator, s.lhs) + " " + genPSA(operator, s.rhs) + ")"
          case s: BasicPolicySet => condName + "_" + s.pol.asInstanceOf[Pol].name
        }
      case "<=" =>
        pSet match {
          case s: MinPolicySet => "(or " + genPSA(operator, s.lhs) + " " + genPSA(operator, s.rhs) + ")"
          case s: MaxPolicySet => "(and " + genPSA(operator, s.lhs) + " " + genPSA(operator, s.rhs) + ")"
          case s: BasicPolicySet => condName + "_" + s.pol.asInstanceOf[Pol].name
        }
    }

    buffer.toString()
  }

  def generate(): String = {
    val buffer = new StringBuilder
    val usedB = for
    (c <- conds;
     b <- findAllPolicySets(conds(c._1).getPol)
    ) yield (b)

    val declarations = for (name <- predicateNames) yield "(declare-const " + name + " Bool)\n"
    val variableDeclarations = for (name <- nonConstantScores) yield "(declare-const " + name + " Real)\n"
    val nonConstantScoreDeclarations = for (name <- nonConstantDefaultScores) yield "(declare-const " + name + " Real)\n"
    val condDeclarations = for (name <- conds.keys) yield "(declare-const " + name + " Bool)\n"

    pols.filter(p => usedB.toSet.contains(p._1)).filter(p => p._2.operator == Plus || p._2.operator == Mul).foreach {
      case (bName, b) =>
        val unit = if (b.operator == Plus) 0.0 else 1.0
        b.rules.foreach {
          predicate =>
            buffer.append("(declare-const " + bName + "_score_" + predicate.q.name + " Real)\n")
            buffer.append("(assert (implies " + predicate.q.name + " (= " + predicate.attribute.fold(score => score.toString(), variable => if (variable.multiplier == 1) variable.name else "(* " + variable.multiplier + " " + variable.name + ")") + " " + bName + "_score_" + predicate.q.name + ")))\n")
            buffer.append("(assert (implies (not (= " + unit + " " + bName + "_score_" + predicate.q.name + ")) " + predicate.q.name + "))\n")
        }
    }

    conds.foreach {
      case (name, c) =>
        findAllPolicySets(conds(name).getPol).foreach {
          b =>
            buffer.append("(declare-const " + name + "_" + b + " Bool)\n")
            buffer.append(generateConditionEnforcement(name, b))
        }

        buffer.append(generatePolicySetAssertions(name))
    }

    val domainSpecifics = input.split("\n").dropWhile(!_.startsWith("DOMAIN_SPECIFICS")).takeWhile(!_.startsWith("ANALYSES")).drop(1)

    val sortedAnalyses = analyses.keys.toSeq.sortWith(_ < _)
    val generatedAnalyses = for (analysis <- sortedAnalyses) yield {
      "(echo \"Result of analysis [" + analyses(analysis).analysisName + "]:\")\n" + analyses(analysis).z3SMTInput
    }

    declarations.mkString("") + variableDeclarations.mkString("") + nonConstantScoreDeclarations.mkString("") + condDeclarations.mkString("") + buffer.toString() + domainSpecifics.mkString("", "\n", "\n") + generatedAnalyses.mkString("")
  }
}
