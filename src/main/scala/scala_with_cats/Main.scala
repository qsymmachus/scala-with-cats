package scala_with_cats

import cats._
import cats.implicits._
import scala_with_cats.printable.PrintableInstances._
import scala_with_cats.printable.PrintableSyntax._

object Main extends App {
  println("Testing printing a Cat with Printable:")
  val kitty = Cat("Toby", 4, "calico")
  kitty.print

  println("Testing printing a Cat with Show (from cats):")
  implicit val catShow: Show[Cat] = Show.show { cat =>
    val name = cat.name
    val age = cat.age
    val color = cat.color

    s"$name is a $age year-old $color cat."
  }
  println(kitty.show)
}

