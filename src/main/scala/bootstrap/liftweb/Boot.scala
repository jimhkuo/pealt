package bootstrap.liftweb

import code.lib.PealInputData
import net.liftweb.common.Full
import net.liftweb.http.{LiftRules, Req, StreamingResponse}
import net.liftweb.sitemap.Loc.{Hidden, LocGroup}
import net.liftweb.sitemap.Menu.{Menuable, WithSlash}
import net.liftweb.sitemap.{Menu, SiteMap}

class Boot {
  def boot {
    LiftRules.addToPackages("code")

    val entries: List[Menuable] = List(
      Menu.i("Editor and runner") / "index",
//      Menu.i("Debug Set") / "debug",
//      Menu.i("Debug Get") / "debug2",
      Menu.i("Settings") / "settings",
      Menu.i("About PEALT") / "aboutpealt",
      Menu.i("User guide") / "userguide",
      Menu.i("About") / "done" >> Hidden,
      Menu.i("Acknowledgements") / "acknowledgements"
    )
    LiftRules.setSiteMap(SiteMap(entries: _*))

    LiftRules.ajaxStart = Full(() => LiftRules.jsArtifacts.show("ajax-loader").cmd)

    LiftRules.ajaxEnd = Full(() => LiftRules.jsArtifacts.hide("ajax-loader").cmd)

    LiftRules.early.append(_.setCharacterEncoding("UTF-8"))

    LiftRules.dispatch.append {
      case req@Req(List("download"), _, _) => {
        val result = PealInputData.is
        val headers = "Content-type" -> "text/plain" :: "Content-length" -> result.length.toString :: "Content-disposition" -> "attachment; filname=pealInput.txt" :: Nil
        () => Full(StreamingResponse(
          new java.io.ByteArrayInputStream(result.getBytes("utf-8")),
          () => {},
          result.length,
          headers, Nil, 200)
        )
      }
    }

//    case SaveFile(result, lapseTime) =>
//    Z3SMTData.set(result)
//    this ! Result(<p>Output prepared, lapse time:
//      <span style="color:red;font-weight: bold;">
//        {"%.2f".format(lapseTime.toDouble / 1000000)}
//      </span>
//      ms, please click
//      <a href="download">here</a>
//      to download the file</p>)
  }
}