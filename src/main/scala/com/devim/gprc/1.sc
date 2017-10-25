import java.util.concurrent.Executors

import cats.effect.IO

import scala.concurrent.ExecutionContext


val testAsync =  IO
  Thread.sleep(5000)
  println(Thread.currentThread().getName)
  val a = 1000
    a
}

val BlockingFileIO = ExecutionContext.fromExecutor(Executors.newCachedThreadPool())

val process =for {
  gg<-testAsync.shift(BlockingFileIO)
} yield gg

process.unsafeRunAsync(cb=>{

})