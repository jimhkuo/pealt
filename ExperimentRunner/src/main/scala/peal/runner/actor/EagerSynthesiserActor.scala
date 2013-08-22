package peal.runner.actor

import akka.actor.{ReceiveTimeout, Actor}
import org.antlr.runtime.{CommonTokenStream, ANTLRStringStream}
import peal.antlr.{PealProgramParser, PealProgramLexer}
import z3.scala.{Z3Config, Z3Context}
import scala.collection.JavaConversions._


class EagerSynthesiserActor extends Actor {

  val z3 = new Z3Context(new Z3Config("MODEL" -> true))

  private def getPealProgramParser(input: String) = {
    val charStream = new ANTLRStringStream(input)
    val lexer = new PealProgramLexer(charStream)
    val tokenStream = new CommonTokenStream(lexer)
    new PealProgramParser(tokenStream)
  }

  def receive = {
    case input: String =>

      val pealProgramParser = getPealProgramParser(input)
      pealProgramParser.program()

      val predicateNames: Seq[String] = pealProgramParser.pols.values().flatMap(pol => pol.rules).map(r => r.q.name).toSeq.distinct
      val constsMap = predicateNames.toSeq.distinct.map(t => (t, z3.mkBoolConst(t))).toMap
      val domainSpecifics = input.split("\n").dropWhile(!_.startsWith("DOMAIN_SPECIFICS")).takeWhile(!_.startsWith("ANALYSES")).drop(1)
      val conds = pealProgramParser.conds.toMap
      val analyses = pealProgramParser.analyses.toMap

      val predicateDeclarations = for (name <- constsMap.keys) yield "(declare-const " + name + " Bool)\n"
      val condDeclarations = for (name <- conds.keys) yield "(declare-const " + name + " Bool)\n"
      val sortedKeys = conds.keys.toSeq.sortWith(_ < _)
      val body = for (cond <- sortedKeys) yield {
        "(assert (= " + cond + " " + conds(cond).synthesis(z3, constsMap) + "))\n"
      }
      val sortedAnalyses = analyses.keys.toSeq.sortWith(_ < _)
      val generatedAnalyses = for (analysis <- sortedAnalyses) yield {
        "(echo \"Result of analysis [" + analyses(analysis).analysisName + "]:\")\n" + analyses(analysis).z3SMTInput
      }

      val z3SMTInput = predicateDeclarations.mkString("") + condDeclarations.mkString("") + body.mkString("") + domainSpecifics.mkString("", "\n", "\n") + generatedAnalyses.mkString("")
      sender ! z3SMTInput

    case ReceiveTimeout => z3.delete()
  }
}
