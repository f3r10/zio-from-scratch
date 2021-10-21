package zio.examples

import zio._
case class Person(name: String, age: Int)

object Person {
  val peter: Person = Person("Peter", 88)
}

trait ZIOApp {
  def run: ZIO[Any]

  def main(args: Array[String]): Unit =
    run.run { result =>
      println(s"The result was ${result}")
    }
}

object succeedNow extends ZIOApp {

  val peterZIO: ZIO[Person] = 
    ZIO.succeedNow(Person.peter)

  def run: ZIO[Person] = peterZIO

}


