package com.devim.gprc

object Tool {

  def main(args: Array[String]): Unit = {
    val terminal = TerminalBuilder
      .builder()
      .system(true)
      .build();
  }

}
