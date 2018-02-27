package scala_with_cats

import scala_with_cats.printable.Printable
import scala_with_cats.printable.PrintableInstances._

object Main extends App {
  println("Testing printing a Cat:")
  val kitty = Cat("Toby", 4, "calico")
  Printable.print(kitty)
}

