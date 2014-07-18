package peal.verifier.util

import peal.domain._
import peal.util.ConsoleLogger

object ScoreEvaluator {

  def trueScore(score: Score, rangeVarName: String)(implicit I: Map[String, Either[Rational, ThreeWayBoolean]], multiplierNamePurger: Multiplier => String = x => x.name): Rational = {

    def eval(e: Multiplier): Rational = {
      ConsoleLogger.log1("eval: " + e.toNaturalExpression + " e.name is " + e.name + " e.multiplier is " + e.multiplier)
      val out = e.name match {
        case s if s.contains("_score") =>
          ConsoleLogger.log1("********* ScoreEvaluator, if s.contains(\"_score\")")
          I(multiplierNamePurger(e)).left.get //* Rational(e.multiplier.toString())
        case s if I.contains(s) && I(s).isLeft =>
          ConsoleLogger.log1("********* ScoreEvaluator, if I.contains(s) && I(s).isLeft")
          Rational(e.multiplier.toString()) * I(s).left.get
        case "" =>
          ConsoleLogger.log1("********* ScoreEvaluator, \"\"")
          Rational(e.multiplier.toString())
        case _ =>
          ConsoleLogger.log1("********* ScoreEvaluator, 0 assumed")
          Rational("0")
      }

      ConsoleLogger.log1("eval: Result = " + out)

      out
    }

    def evaluateFormula(vf: VariableFormula): Rational = {
      vf.operations.foldLeft(Rational("0"))((l, r) => l + eval(r))
    }

    score.scoreRange match {
      case None => score.underlyingScore.fold(s => Rational(s.toString()), f => evaluateFormula(f))
      case Some(_) => score.underlyingScore.fold(s => Rational(s.toString()), f => evaluateFormula(f)) + I(rangeVarName).fold(s => s, vf => throw new RuntimeException("illegal variable format"))
    }
  }
}
