package com.devim.gprc

import org.jline.reader._
import org.jline.terminal.TerminalBuilder

object Tool {

  def main(args: Array[String]): Unit = {
    val terminal = TerminalBuilder
      .builder()
      .system(true)
      .build()

    val reader = LineReaderBuilder
      .builder()
      .terminal(terminal)
      .build()

    reader.readLine(">>> Type help for help\n\n")

  }

}
