package peal.newsynthesis

import peal.antlr.util.ParserHelper
import scala.collection.JavaConversions._
import peal.domain.{MinPolicySet, MaxPolicySet, BasicPolicySet, Pol}
import peal.domain.operator.{Min, Max}
import peal.synthesis.analysis.AlwaysTrue

class NewSynthesiser(input: String) {

  val pealProgramParser = ParserHelper.getPealParser(input)
  pealProgramParser.program()

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

  def generate() = {
    val declarations = for (name <- predicateNames) yield "(declare-const " + name + " Bool)\n"
    val variableDeclarations = for (name <- nonConstantScores) yield "(declare-const " + name + " Real)\n"
    val nonConstantScoreDeclarations = for (name <- nonConstantDefaultScores) yield "(declare-const " + name + " Real)\n"
    val policyScoreDeclarations = for (name <- pols.keySet()) yield "(declare-const " + name + "_score" + " Real)\n"
    val policySetScoreDeclarations = for (name <- pSets.keySet()) yield "(declare-const " + name + "_score" + " Real)\n"

    declarations.mkString("") +
      variableDeclarations.mkString("") +
      nonConstantScoreDeclarations.mkString("") +
      policyScoreDeclarations.mkString("") +
      policySetScoreDeclarations.mkString("") +
      policySetAssertions.mkString("") +
      policyAssertions.mkString("") +
      policyScoreAssertions.mkString("") +
      analysesAssertions.mkString("")
  }

  private def policySetAssertions = {
    for ((name, pSet) <- pSets) yield {
      pSet match {
        case p: BasicPolicySet => "(assert (= " + name + "_score " + p.underlyingPolicyName + "_score))\n"
        case p: MaxPolicySet => "(assert (= " + name + "_score (ite (> " + p.lhs.getPolicySetName + "_score " + p.rhs.getPolicySetName + "_score) " + p.lhs.getPolicySetName + "_score " + p.rhs.getPolicySetName + "_score)))\n"
        case p: MinPolicySet => "(assert (= " + name + "_score (ite (> " + p.rhs.getPolicySetName + "_score " + p.lhs.getPolicySetName + "_score) " + p.lhs.getPolicySetName + "_score " + p.rhs.getPolicySetName + "_score)))\n"
      }
    }
  }

  private def policyAssertions = {
    pols.flatMap {
      case (name, pol) =>
        pol.operator match {
          case Max => pol.rules.map(r => "(assert (implies " + r.q.name + " (<= " + r.scoreString + " " + name + "_score_" + r.q.name + ")))\n")
          case Min => pol.rules.map(r => "(assert (implies " + r.q.name + " (<= " + name + "_score_" + r.q.name + " " + r.scoreString + ")))\n")
        }
    }
  }

  private def defaultCase(p: Pol) = {
    "(and (not (or " + p.rules.map(_.q.name).mkString(" ") + ")) (= " + p.getPolicyName + "_score " + p.scoreString + "))"
  }

  private def nonDefaultCase(p: Pol) = {
    val out = for (r <- p.rules) yield {
      "(and " + r.q.name + " (= " + p.policyName + "_score " + r.scoreString + "))"
    }
    out.mkString("", " ", "")
  }

  private def policyScoreAssertions = {
    for ((name, pol) <- pols) yield {
      "(assert (or " + defaultCase(pol) + " " + nonDefaultCase(pol) + "))\n"
    }
  }

  private def analysesAssertions = {
//    for (analysis <- analyses) yield {
//      analysis match {
//        case AlwaysTrue => //need to pull condition and put the whole content here
//      }
//    }
    ""
  }

  //  "(push)\n" +
  //    "(declare-const always_true_name1 Bool)\n" +
  //    "(assert (= always_true_name1 (< pSet1_score pSet2_score)))\n" +
  //    "(assert (not always_true_name1))\n" +
  //    "(check-sat)\n" +
  //    "(get-model)\n" +
  //    "(pop)\n"
}
