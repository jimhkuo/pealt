package peal.synthesis

import _root_.z3.scala.{Z3AST, Z3Config, Z3Context}
import org.junit.{After, Test}
import org.scalatest.junit.ShouldMatchersForJUnit
import peal.domain.{Rule, Predicate, Pol}
import scala.collection.JavaConversions._
import peal.domain.operator.Min
import peal.util.Z3ModelMatcher
import peal.domain.z3.wrapper.{Term, PealAst}

class ThLessThanPolTest extends ShouldMatchersForJUnit with Z3ModelMatcher {
  val z3: Z3Context = new Z3Context(new Z3Config("MODEL" -> true))
  val consts = Map[String, PealAst]("q0" -> Term("q0"), "q1" -> Term("q1"), "q2" -> Term("q2"), "q3" -> Term("q3"), "q4" -> Term("q4"), "q5" -> Term("q5"), "q6" -> Term("q6"))

  @After def tearDown() {
    z3.delete()
  }

  @Test
  def testThLessThanDefault() {
    val p = new Pol(List(new Rule(new Predicate("q1"), 0.5)), Min, 0.7)
    val phi = new ThLessThanPolCondition(p, 0.6)
    phi.synthesis(z3, consts) should beZ3Model("(or (not q1) (not q1))")
  }

  @Test
  def testDefaultLessThanTh() {
    val p = new Pol(List(new Rule(new Predicate("q1"), 0.5)), Min, 0)
    val phi = new ThLessThanPolCondition(p, 0.6)
    phi.synthesis(z3, consts) should beZ3Model("(and q1 (not q1))")
  }
}
