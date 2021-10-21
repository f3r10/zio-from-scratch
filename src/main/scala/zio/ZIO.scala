package zio

sealed trait ZIO[+A] {
  // 1. as def run: A it will imply that the function
  // will run right away. Instead it is necessary that
  // the function get as a parameter a callback.
  // callback is also call a continuation
  def run(callback: A => Unit): Unit
}

object ZIO {

  def succeedNow[A](value: A): ZIO[A] =  ZIO.Succeed(value)


  //1. case class will allows us to make safety stacktrace calls
  case class Succeed[A](value: A) extends ZIO[A] {

    override def run(callback: A => Unit): Unit = callback(value)

  }

}
