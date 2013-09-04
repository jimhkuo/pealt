package peal.runner.actor

import akka.actor.Actor
import java.io.File
import scala.sys.process._
import util.FileUtil

class ProcessKillerActor extends Actor {

  def receive = {
    case file: File =>
      val execTmp = File.createTempFile("kill", "")
      execTmp.setExecutable(true)
      val script = "foreach (`ps -A -f | grep " + file.getAbsoluteFile + " | grep nw`)  {\n@a = split;\n$pid = $a[1];\n$exists = kill 0, $pid;\n`kill -9 $pid` if ($exists);}"
      FileUtil.writeToFile(execTmp.getAbsolutePath, script)
      val out = Seq("perl", execTmp.getAbsolutePath).!!
      execTmp.delete()
      out
  }
}