package peal.domain

import scala.collection.JavaConversions._
import peal.domain.operator.Operators

case class Pol(rules: java.util.List[Rule], operator: Operators, defaultScore: BigDecimal, name: String = "") extends PolicySet {
  override def toString: String = operator + " (" + rules.mkString(" ") + ") default " + "%.2f".format(defaultScore.doubleValue())

  //needed by Java classes
  def getName = name
}