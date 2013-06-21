package peal

import peal.synthesis.NonDefaultSet
import peal.domain.Pol
import scala._
import scala.collection.JavaConversions._


class NonDefaultThLessThanPolOpMax(pol: Pol, th: Double) extends NonDefaultSet {
  def synthesis: String = {
    val rules = pol.rules.filter(th < _.score)
    rules.size match {
      case 0 => "false"
      case 1 => rules.map(_.q.name).mkString("")
    }
  }


}
