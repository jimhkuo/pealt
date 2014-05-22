package peal.verifier

import org.scalatest.junit.ShouldMatchersForJUnit
import org.junit.Test


class Z3ModelExtractorTest extends ShouldMatchersForJUnit {

  @Test
  def testCanExtractSimpleModel() {
    val model = "Result of analysis [name1 = always_true? cond1]:\nsat\n(model \n  (define-fun cond1 () Bool\n    false)\n  (define-fun q1 () Bool\n    false)\n  (define-fun q3 () Bool\n    false)\n  (define-fun q2 () Bool\n    false)\n  (define-fun always_true_name1 () Bool\n    false)\n)"
    Z3ModelExtractor.extractAssignments(model)("name1").assignment.toString() should be ("[cond1 (Bool) = false, q1 (Bool) = false, q3 (Bool) = false, q2 (Bool) = false, always_true_name1 (Bool) = false]")
  }

  @Test
  def testCanExtractBrokenModel() {
    val model = "Result of analysis [analysis1 = always_true? cond1]:\n\nsat\n\n(model \n\n  (define-fun cond1 () Bool\n\n    false)\n\n  (define-fun always_true_analysis1 () Bool\n\n    false)\n\n  (define-fun cond2 () Bool\n\n    false)\n\n)\n\nResult of analysis [analysis2 = always_false? cond2]:\n\nunsat\n\n(error \"line 25 column 10: model is not available\")\n\nResult of analysis [analysis3 = different? cond1 cond2]:\n\nunsat\n\n(error \"line 33 column 10: model is not available\")"
    Z3ModelExtractor.extractAssignments(model)("analysis1").assignment.toString() should be ("[cond1 (Bool) = false, always_true_analysis1 (Bool) = false, cond2 (Bool) = false]")
  }

  @Test
  def testCanExtractModelFromExtendedSynthesis() {
      val model = "Result of analysis [name1 = satisfiable? cond1]:\nsat\n(model \n  (define-fun b1_score () Real\n    (/ 1.0 2.0))\n  (define-fun cond3 () Bool\n    false)\n  (define-fun y () Real\n    0.0)\n  (define-fun q4 () Bool\n    true)\n  (define-fun cond2 () Bool\n    false)\n  (define-fun cond1 () Bool\n    true)\n  (define-fun satisfiable_name1 () Bool\n    true)\n  (define-fun q1 () Bool\n    false)\n  (define-fun b1_default_U () Real\n    0.0)\n  (define-fun q5 () Bool\n    true)\n  (define-fun b () Real\n    (- 1.0))\n  (define-fun cond4 () Bool\n    true)\n  (define-fun q3 () Bool\n    false)\n  (define-fun a () Real\n    0.0)\n  (define-fun q2 () Bool\n    false)\n  (define-fun b1_q1_U () Real\n    0.0)\n  (define-fun z () Real\n    (/ 5.0 8.0))\n  (define-fun b2_score () Real\n    (/ 1.0 2.0))\n  (define-fun q6 () Bool\n    true)\n  (define-fun b2_q6_U () Real\n    0.0)\n  (define-fun x () Real\n    5.0)\n)"
  }
}
