package peal.synthesis

import peal.domain._
import peal.domain.Pol
import peal.domain.z3.{PealAst, Or, And}

//TODO consider using Either for th
case class GreaterThanThCondition(phi: PolicySet, th: BigDecimal) extends Condition {

  if (phi == null) throw new RuntimeException("Referred to undeclared policy set in GreaterThanThCondition")

  def synthesis(consts: Map[String, PealAst]): PealAst = phi match {
    case s: MinPolicySet => And(new GreaterThanThCondition(s.lhs, th).synthesis(consts), new GreaterThanThCondition(s.rhs, th).synthesis(consts))
    case s: MaxPolicySet => Or(new GreaterThanThCondition(s.lhs, th).synthesis(consts), new GreaterThanThCondition(s.rhs, th).synthesis(consts))
    case s: BasicPolicySet => new GreaterThanThCondition(s.pol, th).synthesis(consts)
    case s: Pol => new ThLessThanPolSynthesiser(s, th).synthesis(consts)
  }

  def getPol = Some(phi)

  def getTh = th
}
