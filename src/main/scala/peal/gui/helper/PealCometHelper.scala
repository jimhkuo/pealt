package peal.gui.helper

import code.lib.VcOption
import peal.antlr.util.ParserHelper
import peal.domain.PolicySet
import peal.domain.z3.{PealAst, Term}
import peal.synthesis.analysis.AnalysisGenerator
import peal.synthesis.{Condition, ExplicitSynthesiser, ExtendedSynthesiser}

import scala.collection.JavaConversions._
import scala.util.Try

object PealCometHelper {

  def tryExplicitSynthesis(policies: String): Try[String] = Try {
    new ExplicitSynthesiser(policies).generate(VcOption.get)
  }

  def tryExtendedSynthesis(policies: String): Try[String] = Try {
    new ExtendedSynthesiser(policies).generate(VcOption.get)
  }

  def tryToParsePealInput(input: String): Try[(Map[String, PealAst], Map[String, Condition], Map[String, PolicySet], Map[String, AnalysisGenerator], Array[String])] = Try {
    val pealProgramParser = ParserHelper.getPealParser(input)

    pealProgramParser.program()
    val predicateNames: Seq[String] = pealProgramParser.pols.values().flatMap(pol => pol.rules).map(r => r.q.name).toSeq.distinct
    val constsMap = predicateNames.toSeq.distinct.map(t => (t, Term(t))).toMap
    val domainSpecifics = input.split("\n").dropWhile(!_.startsWith("DOMAIN_SPECIFICS")).takeWhile(!_.startsWith("ANALYSES")).drop(1)

    (constsMap, pealProgramParser.conds.toMap, pealProgramParser.pSets.toMap, pealProgramParser.analyses.toMap, domainSpecifics)
  }
}
