package scala_with_cats

import cats._
import cats.implicits._
import scala_with_cats.printable.PrintableInstances._
import scala_with_cats.printable.PrintableSyntax._

object Main extends App {
  val toby = Cat("Toby", 4, "calico")
  val ralph = Cat("Ralph", 10, "orange")

  println("Testing printing a Cat with Printable:")
  ralph.print

  println("Testing printing a Cat with Show (from cats):")
  implicit val catShow: Show[Cat] = Show.show { cat =>
    val name = cat.name
    val age = cat.age
    val color = cat.color

    s"$name is a $age year-old $color cat."
  }
  println(ralph.show)

  println("Testing Eq with some Cats:")
  implicit val catEq: Eq[Cat] = Eq.instance[Cat] { (cat1, cat2) =>
    (cat1.name === cat2.name) &&
    (cat1.age === cat2.age) &&
    (cat1.color === cat2.color)
  }
  println(ralph === toby)
      
}

