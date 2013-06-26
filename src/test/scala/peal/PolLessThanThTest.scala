package peal

import org.junit.{Ignore, Test}
import org.scalatest.junit.ShouldMatchersForJUnit
import peal.domain.{Rule, Predicate, Pol}
import scala.collection.JavaConversions._
import peal.domain.operator.Min

class PolLessThanThTest extends ShouldMatchersForJUnit {

  @Test
  def testDefaultLessThanTh() {
    val p = new Pol(List(new Rule(new Predicate("q1"), 0.5)), Min, 0)
    val phi = new PolLessThanTh(p, 0.6)

    phi.synthesis should be("(or (not q1) q1)")
  }

  @Test
  def testDefaultLessThanThMultipleRules() {
    val p = new Pol(List(new Rule(new Predicate("q1"), 0.5), new Rule(new Predicate("q2"), 0.3)), Min, 0)
    val phi = new PolLessThanTh(p, 0.6)

    phi.synthesis should be("(or (and (not q1) (not q2)) (or q1 q2))")
  }

  @Test
  def testDefaultGreaterThanTh() {
    val p = new Pol(List(new Rule(new Predicate("q1"), 0.5)), Min, 1)
    val phi = new PolLessThanTh(p, 0.6)

    phi.synthesis should be("(and q1 q1)")
  }

  @Test
  def testDefaultGreaterThanThMultipleRules() {
    val p = new Pol(List(new Rule(new Predicate("q1"), 0.5), new Rule(new Predicate("q2"), 0.3)), Min, 1)
    val phi = new PolLessThanTh(p, 0.6)

    phi.synthesis should be("(and (or q1 q2) (or q1 q2))")
  }
}
