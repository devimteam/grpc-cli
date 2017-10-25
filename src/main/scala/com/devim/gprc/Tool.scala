package com.devim.gprc

import org.jline.reader._
import org.jline.reader.impl.DefaultHighlighter
import org.jline.reader.impl.completer.{ArgumentCompleter, StringsCompleter}
import org.jline.terminal.{Terminal, TerminalBuilder}
import org.jline.utils.AttributedString
import org.jline.utils.InfoCmp.Capability

import scala.annotation.tailrec

object Tool {

  import utils._
  def main(args: Array[String]): Unit = {

    autoClose(
      TerminalBuilder
        .builder()
        .system(true)
        .nativeSignals(true)
        .signalHandler(Terminal.SignalHandler.SIG_IGN)
        .build()) { terminal =>
      val reader = LineReaderBuilder
        .builder()
        .completer(new ArgumentCompleter(new StringsCompleter("help")))
        .highlighter(new DefaultHighlighter())
        .terminal(terminal)
        .build()
      val context = Context(reader,terminal)
      read(context)
    }

  }

  @tailrec
  def read(context: Context): Unit = {
    val line = context.lineReader.readLine(">>> ")
    line match {
      case "exit" => {}
      case str =>
        command.process.run((str, context)).unsafeRunSync()
        read(context)
    }
  }

}
