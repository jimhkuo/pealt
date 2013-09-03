package peal.runner.actor

import akka.actor.Actor
import peal.eagersynthesis.EagerSynthesiser
import java.io.File
import scala.sys.process._

class EagerSynthesiserActor extends Actor {

  var synthesiser = new EagerSynthesiser()

  def receive = {
    case tmp: File =>
      //TODO skip this class, go into EFS directly
      val synthesisedOutput = Seq("java", "-Xmx10240m", "-Xss32m", "-cp", "./Peal.jar", "peal.eagersynthesis.EagerFileSynthesiser", tmp.getAbsolutePath).!!
      sender ! synthesisedOutput
  }
}
