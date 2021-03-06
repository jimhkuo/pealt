package peal.maximise

import peal.antlr.util.ParserHelper
import peal.domain.operator.Mul
import peal.domain.z3.{Unsat, Sat, SatResult}
import peal.domain._
import peal.synthesis.analysis.Satisfiable
import peal.synthesis.{LessThanThCondition, ExtendedSynthesiserCore, GreaterThanThCondition}
import peal.util.ConsoleLogger
import peal.verifier.{OutputVerifier, Z3ModelExtractor}
import peal.z3.Z3Caller

import scala.collection.JavaConversions._


case class MaximisePSet(input: String, pSet: String, accuracy: BigDecimal, pol: String = "") {

  val policiesSection = input.split("\n").dropWhile(!_.startsWith("POLICIES")).takeWhile(l => !l.startsWith("POLICY_SETS") && !l.startsWith("CONDITIONS") && !l.startsWith("DOMAIN_SPECIFICS") && !l.startsWith("ANALYSES")).drop(1).filterNot(_.trim.startsWith("%")).mkString("\n")
  val policySetsSection = input.split("\n").dropWhile(!_.startsWith("POLICY_SETS")).takeWhile(l => !l.startsWith("CONDITIONS") && !l.startsWith("DOMAIN_SPECIFICS") && !l.startsWith("ANALYSES")).drop(1).filterNot(_.trim.startsWith("%")).mkString("\n")
  val domainSpecifics = input.split("\n").dropWhile(!_.startsWith("DOMAIN_SPECIFICS")).takeWhile(!_.startsWith("ANALYSES")).drop(1).filterNot(_.trim.startsWith("%"))

  val inputWithoutConditionAndTheRest = s"POLICIES\n$policiesSection\nPOLICY_SETS\n$policySetsSection\n"

  val pealProgramParser = ParserHelper.getPealParser(inputWithoutConditionAndTheRest)
  pealProgramParser.program()
  val pols = pealProgramParser.pols.toMap
  val allRules = pols.values.flatMap(pol => pol.rules)
  val predicateNames: Set[String] = allRules.map(r => r.q.name).toSet
  val variableDefaultScores: Set[String] = pols.foldLeft(Set[String]())((acc, tuple) => {
    tuple._2 match {
      case p: Pol =>
        def addVariables(set: Set[String]) = p.score.underlyingScore.fold(score => set, variable => set ++ variable.names)
        addVariables(acc)
      case _ => acc
    }
  })
  val variableScores: Set[String] = allRules.foldLeft(Set[String]())((acc, rule) => {
    def addVariables(set: Set[String]) = rule.score.underlyingScore.fold(score => set, variable => set ++ variable.names)
    addVariables(acc)
  })
  val pSets: Map[String, PolicySet] = pealProgramParser.pSets.toMap

  private def runStrictAnalysis(threshold: BigDecimal)(implicit doMin: Boolean): (SatResult, Map[String, Either[Rational, ThreeWayBoolean]]) = runAnalysis(threshold, "<")

  private def runRelaxedAnalysis(threshold: BigDecimal)(implicit doMin: Boolean): (SatResult, Map[String, Either[Rational, ThreeWayBoolean]]) = runAnalysis(threshold, "<=")

  private def runAnalysis(threshold: BigDecimal, operator: String)(implicit doMin: Boolean): (SatResult, Map[String, Either[Rational, ThreeWayBoolean]]) = {

    val pSetName = pSet + (if (pol != "") "_" + pol else "")

    def setupPolicies = doMin match {
      case false => "POLICIES\n" + policiesSection + "\n"
      case _ => "POLICIES\n" + policiesSection + "\nb_min_1 = *((True -1)) default 0\n"
    }

    def setupPolicySets = doMin match {
      case false => "POLICY_SETS\n" + policySetsSection + "\n"
      case _ => s"POLICY_SETS\n$policySetsSection\n${pSetName}_neg_1 = b_min_1\n${pSetName}_min = * (${pSetName}_neg_1, ${pSetName})\n"
    }

    def setupConditions = doMin match {
      case false => operator match {
        case "<" => "CONDITIONS\ncond1 = " + threshold + " < " + pSetName + "\n"
        case _ => "CONDITIONS\ncond1 = " + pSetName + " <= " + threshold + "\n"
      }
      case _ => operator match {
        case "<" => "CONDITIONS\ncond1 = " + threshold + " < " + pSetName + "_min\n"
        case _ => "CONDITIONS\ncond1 = " + pSetName + "_min <= " + threshold + "\n"
      }
    }

    def setupDomainSpecifics = doMin match {
      case true if !domainSpecifics.contains("(assert True)") => "DOMAIN_SPECIFICS\n" + domainSpecifics.mkString("\n") + "\n(assert True)\n"
      case _ => "DOMAIN_SPECIFICS\n" + domainSpecifics.mkString("\n") + "\n"
    }

    def inputWithReplacedConditionAndAnalysis = {
      setupPolicies +
        setupPolicySets +
        setupConditions +
        setupDomainSpecifics +
        "ANALYSES\nname1 = satisfiable? cond1"
    }


    //I do this to avoid parsing the entire peal input every time
    val modifiedPols = doMin match {
      case false => pols
      case _ => pols ++ Map("b_min_1" -> new Pol(List(new Rule(new Predicate("True"), -1)), Mul, "0"))
    }

    val modifiedPSets = doMin match {
      case false => pSets
      case _ =>
        val pol = Pol(List(new Rule(new Predicate("True"), -1)), Mul, new Score(Left(0), None), "b_min_1")
        val negOne = BasicPolicySet(pol, "b_min_1")
        pSets ++ Map(pSetName + "_neg_1" -> negOne, pSetName + "_min" -> MulPolicySet(negOne, pSets(pSetName), pSetName + " _min"))
    }

    val conds = doMin match {
      case false => operator match {
        case "<" => Map("cond1" -> GreaterThanThCondition(pSets(pSetName), Left(threshold)))
        case _ => Map("cond1" -> LessThanThCondition(pSets(pSetName), Left(threshold)))
      }
      case _ => operator match {
        case "<" => Map("cond1" -> GreaterThanThCondition(modifiedPSets(pSetName + "_min"), Left(threshold)))
        case _ => Map("cond1" -> LessThanThCondition(modifiedPSets(pSetName + "_min"), Left(threshold)))
      }
    }

    val analyses = Map("name1" -> new Satisfiable("name1", "cond1"))
    val generatedZ3Code = ExtendedSynthesiserCore(modifiedPols, conds, modifiedPSets, analyses, domainSpecifics, predicateNames, variableDefaultScores, variableScores).generate()
    val z3RawOutput = Z3Caller.call(generatedZ3Code)

    OutputVerifier(inputWithReplacedConditionAndAnalysis).verifyModel(z3RawOutput, "name1")._1 match {
      case PealTrue => Z3ModelExtractor.extractIAndStatusUsingRational(z3RawOutput)("name1")
      case PealBottom => throw new RuntimeException(s"satisfiable? $threshold < $pSetName is UNKNOWN")
      case PealFalse => throw new RuntimeException(s"Certification of $threshold < $pSet failed")
    }
  }

  private def bisection(inputLow: BigDecimal, inputHigh: BigDecimal)(implicit doMin: Boolean): String = {
    var low = inputLow
    var high = inputHigh
    while ((high - low) > accuracy) {
      val middle = (low + high) / 2
      val I = runStrictAnalysis(middle)
      if (I._1 == Sat) {
        if (pol.nonEmpty) {
          val temp = I._2(pol + "_score").left.get.value
          val J = runStrictAnalysis(temp)._1
          if (J == Unsat) {
            return outputProcessor(temp)
          }
          low = temp.max(middle)
        } else {
          low = middle
        }
      } else {
        high = middle
      }
    }

    doMin match {
      case false => "maximum (after calling bisection method with low = " + inputLow + " and high = " + inputHigh + ") is in half-open interval (" + low + ", " + high + "]"
      case _ => "minimum (after calling bisection method with low = " + inputLow + " and high = " + inputHigh + ") is in half-open interval (" + (-high) + ", " + (-low) + "]"
    }
  }

  private def outputProcessor(temp: BigDecimal)(implicit doMin: Boolean): String = doMin match {
    case false => "exact maximum is " + temp
    case _ => "exact minimum is " + (-temp)
  }

  def doIt(doMinFlag: Boolean = false): String = {
    implicit val doMin = doMinFlag
    val I = runStrictAnalysis(0.0)
    var high, low = BigDecimal(0.0)

    if (I._1 == Sat) {
      if (pol.nonEmpty) {
        val temp = I._2(pol + "_score").left.get.value
        val J = runStrictAnalysis(temp)._1
        if (J == Unsat) {
          return outputProcessor(temp)
        }
      }

      high = low.max(2.0)
      var K = runStrictAnalysis(high)
      while (K._1 == Sat) {
        if (pol.nonEmpty) {
          val temp = K._2(pol + "_score").left.get.value
          val J = runStrictAnalysis(temp)._1
          if (J == Unsat) {
            return outputProcessor(temp)
          }
          low = temp.max(high)
          high = 2 * low.max(high)
        }
        else {
          low = high
          high = 2 * high
        }
        K = runStrictAnalysis(high)
      }

      bisection(low, high)
    }
    else {
      if (pol.nonEmpty) {
        val I = runRelaxedAnalysis(0.0)
        if (I._1 != Sat) {
          throw new RuntimeException("Unsat in the else branch")
        } else {
          low = I._2(pol + "_score").left.get.value - accuracy
        }
      }
      else {
        low = BigDecimal("-2.0")
        var J = runStrictAnalysis(low)
        while (J._1 == Unsat) {
          low = 2 * low
          J = runStrictAnalysis(low)
        }
      }
      bisection(low, high)
    }
  }
}
