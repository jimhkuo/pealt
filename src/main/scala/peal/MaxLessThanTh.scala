package peal

import peal.domain.Pol
import peal.synthesis.pSet
import scala.collection.JavaConversions._


class MaxLessThanTh(lhs: Pol, rhs: pSet, th: Double) extends pSet {
  //TODO need to handle the situation where rhs is also a TopSet

  def synthesis = rhs match {
    case _: Pol => "(and " + new PolLessThanTh(lhs, th).synthesis + " " + new PolLessThanTh(rhs.getPol, th).synthesis + ")"
  }



  def z3SMTHeader: String = lhs.rules.map(p => "(declare-const " + p.q.name + " Bool)").mkString("", "\n", "\n") +
    rhs.getPol.rules.map(p => "(declare-const " + p.q.name + " Bool)").mkString("", "\n", "\n")
}