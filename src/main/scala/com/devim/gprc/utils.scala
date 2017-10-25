package com.devim.gprc

object utils {
  def autoClose[A <: AutoCloseable, B](closeable: A)(fun: (A) ⇒ B): B = {
    try {
      fun(closeable)
    } finally {
      closeable.close()
    }
  }
}
