package peal.synthesis.analysis

import org.junit.Test
import org.scalatest.junit.ShouldMatchersForJUnit


class ImplyTest extends ShouldMatchersForJUnit {

   @Test
   def testCreateZ3SMTInput() {

     val expected = "(push)\n" +
       "(declare-const imply_name1 Bool)\n" +
       "(assert (= imply_name1 (or (not cond1) cond2)))\n" +
       "(assert imply_name1)\n" +
       "(check-sat)\n" +
       "(get-model)\n" +
       "(pop)\n"
     new Imply("name1", "cond1", "cond2").z3SMTInput should be(expected)
   }
 }
