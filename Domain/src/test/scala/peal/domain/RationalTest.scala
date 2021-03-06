package peal.domain

import org.junit.Test
import org.scalatest.junit.ShouldMatchersForJUnit


class RationalTest extends ShouldMatchersForJUnit {

  @Test
  def testPrecisionOfWholeNumberIs0() {
    (Rational("1.0") * Rational("1.0")).toString should be("Rational(1,1)")
    Rational("0.000").toString should be("Rational(0,1)")
  }

  @Test
  def testPrecisionOfDecimalNumberIsUnchanged() {
    Rational("0.21").value.toString should be("0.21")
  }

  @Test
  def testEquivalency() {
    Rational("-1.5") should be(Rational(-3, 2))
    Rational("1.5", "-1") should be(Rational(-3, 2))
    Rational("1.0", "2.0") should be(Rational("1", "2"))
    Rational("1.5") should be(Rational("3", "2"))
    Rational("-1.5") should be(Rational("-3", "2"))
    Rational("-1.5") should be(Rational("3", "-2"))
    Rational("3", "2") should be(Rational("3.0", "2"))
    Rational("3", "2") should be(Rational("1.5", "1.0"))
    Rational("30", "20") should be(Rational("15", "10"))
  }

  @Test
  def testMax() {
    Rational("1.5").max(Rational("1")) should be(Rational("1.5"))
    Rational("15", "10").max(Rational("10", "9")) should be(Rational("1.5"))
    Rational("-15", "10").max(Rational("10", "9")) should be(Rational("10", "9"))
  }

  @Test
  def testMin() {
    Rational("1.5").min(Rational("1")) should be(Rational("1"))
    Rational("15", "10").min(Rational("10", "9")) should be(Rational("10", "9"))
    Rational("-15", "10").min(Rational("10", "9")) should be(Rational("-15", "10"))
  }

  @Test
  def testMul() {
    Rational("1.5") * Rational("1") should be(Rational("1.5"))
    Rational("15", "10") * Rational("10", "9") should be(Rational("15", "9"))
    Rational("-15", "10") * Rational("10", "9") should be(Rational("-15", "9"))
    Rational(12477, 10000) * Rational("6365127", "1.343E+7") should be(Rational(79417689579l, 1.343E+11))
  }

  @Test
  def testPlus() {
    Rational("1.5") + Rational("1") should be(Rational("2.5"))
    Rational("15", "10") + Rational("10", "9") should be(Rational("235", "90"))
    Rational("-15", "10") + Rational("10", "9") should be(Rational("-35", "90"))
  }
}
