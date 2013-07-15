package peal.antlr

import org.junit.{After, Test}
import org.antlr.runtime.{CommonTokenStream, ANTLRStringStream}
import org.scalatest.junit.ShouldMatchersForJUnit
import scala.collection.JavaConversions._
import z3.scala.{Z3AST, Z3Config, Z3Context}
import peal.util.Z3ModelMatcher
import peal.domain.z3.{Define, Sat, Unsat, Model}


class Z3OutputParserTest extends ShouldMatchersForJUnit with Z3ModelMatcher {
  val z3: Z3Context = new Z3Context(new Z3Config("MODEL" -> true))
  val consts = Map[String, Z3AST]("q1" -> z3.mkBoolConst("q1"), "q2" -> z3.mkBoolConst("q2"), "q3" -> z3.mkBoolConst("q3"), "q4" -> z3.mkBoolConst("q4"), "q5" -> z3.mkBoolConst("q5"), "q6" -> z3.mkBoolConst("q6"))

  @After def tearDown() {
    z3.delete()
  }

  private def getParser(input: String) = {
    val charStream = new ANTLRStringStream(input)
    val lexer = new Z3OutputLexer(charStream)
    val tokenStream = new CommonTokenStream(lexer)
    new Z3OutputParser(tokenStream)
  }

  @Test
  def testSimpleUnsatInput() {
    val input = "Result of analysis [name7 = different? cond2 cond3]:\n" +
      "unsat\n" +
      "(error \"line 73 column 10: model is not available\")"

    val parser = getParser(input)

    val results = parser.results()
    results should contain key ("name7")
    results("name7").satResult should be (Unsat)
  }

  @Test
  def testSimpleSatInput() {
    val input = "Result of analysis [name8 = different? cond2 cond4]:\n" +
      "sat\n" +
      "(model \n  (define-fun q5 () Bool\n    true)\n" +
      "  (define-fun different_name8 () Bool\n    true)\n" +
      "  (define-fun q6 () Bool\n    true)\n)"

    val parser = getParser(input)

    val results = parser.results()
    results should contain key ("name8")
    results("name8").satResult should be (Sat)
    results("name8").defines(0).name should be ("q5")
    results("name8").defines(0).objectType should be ("Bool")
    results("name8").defines(0).value should be (true)
    results("name8").defines(1).name should be ("different_name8")
    results("name8").defines(2).name should be ("q6")
  }
}