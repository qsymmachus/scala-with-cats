package scala_with_cats

import cats.implicits._
import scala_with_cats.cat.Cat
import scala_with_cats.printable.PrintableInstances._
import scala_with_cats.printable.PrintableSyntax._

object Main extends App {
  val toby = Cat("Toby", 4, "calico")
  val ralph = Cat("Ralph", 10, "orange")

  println("Testing printing a Cat with Printable:")
  ralph.print

  println("Testing printing a Cat with Show:")
  println(ralph.show)

  println("Testing Eq with some Cats:")
  println(ralph === toby)
}

