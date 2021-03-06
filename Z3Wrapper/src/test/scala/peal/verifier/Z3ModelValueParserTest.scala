package peal.verifier

import org.junit.Test
import org.scalatest.junit.ShouldMatchersForJUnit
import peal.domain.{PealFalse, PealTrue}


class Z3ModelValueParserTest extends ShouldMatchersForJUnit {

   @Test
   def testCanParseThreeWayBool() {
     Z3ModelValueParser.parse("false") should be (Right(PealFalse))
     Z3ModelValueParser.parse("true") should be (Right(PealTrue))
   }

  @Test
  def testCanParseNegNumber() {
    Z3ModelValueParser.parse("-1.0") should be (Left(BigDecimal(-1)))
  }

  @Test
  def testCanParseRationalNumber() {
    Z3ModelValueParser.parse("1.0/2.0") should be (Left(BigDecimal(0.5)))
  }

  @Test
  def testCanParseNegRationalNumber() {
    Z3ModelValueParser.parse("-1.0/2.0") should be (Left(BigDecimal(-0.5)))
  }
 }
