package peal.domain

import org.junit.Test
import peal.model.RandomModelGenerator

class ModelGeneratorTest {

  @Test
  def test() {
    println(RandomModelGenerator.generate(10, 5, 4, 3, 2, 7, 0.6, 0.1))
  }

  @Test
  def testBuildLattice() {
    val x = 16

    var n = math.pow(2, math.sqrt(x).toInt).toInt

    println(n)

    while (n != 1) {
      val base = for (i <- 0 until n by 2) yield (i)
      val base2 = for (i <- 1 until n by 2) yield (i)
      val basePairs = base.zip(base2)
      println(basePairs)

      n = basePairs.size
    }

  }

}