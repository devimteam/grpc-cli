package com.devim.gprc

import cats.data.Reader
import cats.effect.IO

object command {

  type Command = String

  def process: Reader[(Command, Context), IO[Unit]] =
    Reader {
      case (command: Command, ctx: Context) =>
        IO {
          ctx.terminal.writer().write(s"$command")
        }
    }

}
