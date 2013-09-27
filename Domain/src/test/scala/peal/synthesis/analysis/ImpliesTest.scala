package peal.synthesis.analysis

import org.junit.Test
import org.scalatest.junit.ShouldMatchersForJUnit


class ImpliesTest extends ShouldMatchersForJUnit {

   @Test
   def testCreateZ3SMTInput() {

     val expected = "(push)\n" +
       "(declare-const implies_name1 Bool)\n" +
       "(assert (= implies_name1 (and cond1 (not cond2))))\n" +
       "(assert implies_name1)\n" +
       "(check-sat)\n" +
       "(get-model)\n" +
       "(pop)\n"
     new Implies("name1", "cond1", "cond2").z3SMTInput should be(expected)
   }
 }