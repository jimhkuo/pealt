package peal.runner

import scala.concurrent.Await
import scala.concurrent.duration._
import scala.collection.JavaConversions._
import akka.pattern.ask
import akka.util.Timeout
import akka.actor.{Props, ActorSystem}
import peal.runner.actor._
import java.io.File
import util.FileUtil
import scala.sys.process._
import java.util.concurrent.TimeoutException
import peal.verify.ExplicitOutputVerifier
import peal.antlr.util.ParserHelper


class VerificationExperimentRunner(doDomainSpecifics: Boolean, system: ActorSystem, duration: Long, z3CallerMemoryBound: Long, runModes: RunMode*) {
  implicit val timeout = Timeout(duration, MILLISECONDS)

  def runRandomModel(n: Int, min: Int, max: Int, plus: Int, mul: Int, k: Int, th: Double, delta: Double): TimingOutput = {
    val model = Seq("java", "-Xmx5120m", "-Xss32m", "-cp",
      ModelGeneratorRunner.getClass.getProtectionDomain.getCodeSource.getLocation.getFile,
      "peal.runner.ModelGeneratorRunner",
      doDomainSpecifics.toString,
      n.toString,
      min.toString,
      max.toString,
      plus.toString,
      mul.toString,
      k.toString,
      th.toString,
      delta.toString).!!

    runExperiment(model)
  }

  private def runExperiment(model: String): TimingOutput = {
    val output = new TimingOutput()
    val processKiller = system.actorOf(Props[ProcessKillerActor])
    val randomModelFile = File.createTempFile("randomModel", "")

    try {
      FileUtil.writeToFile(randomModelFile.getAbsolutePath, model)
      print("m")

      val z3Input = Seq("java", "-Xmx25600m", "-Xss32m", "-cp", TimeoutSynthesisRunner.getClass.getProtectionDomain.getCodeSource.getLocation.getFile, "peal.runner.TimeoutSynthesisRunner", "explicit", randomModelFile.getAbsolutePath).!!
      if (z3Input.trim == "TIMEOUT") {
        throw new TimeoutException("Timeout in explicit Synthesis")
      }

      output.eagerSynthesis = z3Input.split("\n")(0).toLong
      print("e")

      val z3InputFile = File.createTempFile("z3File", "")
      FileUtil.writeToFile(z3InputFile.getAbsolutePath, z3Input)

      val z3Caller = system.actorOf(Props(new Z3CallerActor(z3CallerMemoryBound)))

      try {
        val start = System.nanoTime()
        val future = z3Caller ? z3InputFile
        val rawZ3Result = Await.result(future, timeout.duration)
        val lapsedTime = System.nanoTime() - start

        val resultsMap = ReturnedModelAnalyser.execute(rawZ3Result.asInstanceOf[String])

        resultsMap.size match {
          case 0 => throw new RuntimeException("Z3 caller aborted")
          case _ => output.modelResults.append(resultsMap)
        }

        output.eagerZ3 = lapsedTime

        print("z")

        //TODO do verification here, record time
        val pealProgramParser = ParserHelper.getPealParser(model)
        pealProgramParser.program()

        pealProgramParser.analyses.keys.foreach{
          k =>
          new ExplicitOutputVerifier(model).verifyModel(rawZ3Result.asInstanceOf[String], k)

        }



      } catch {
        case e: TimeoutException => processKiller ! z3InputFile
          throw e
      } finally {
        system.stop(z3Caller)
      }

      output.isSameOutput = true
      output
    }
    finally {
      randomModelFile.delete()
    }
  }
}

