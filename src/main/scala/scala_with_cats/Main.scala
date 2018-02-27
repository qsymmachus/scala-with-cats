package scala_with_cats

import scala_with_cats.printable.PrintableInstances._
import scala_with_cats.printable.PrintableSyntax._

object Main extends App {
  println("Testing printing a Cat:")
  val kitty = Cat("Toby", 4, "calico")
  kitty.print
}

