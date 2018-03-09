package scala_with_cats.cat

import cats._
import cats.implicits._

final case class Cat(name: String, age: Int, color: String)

object Cat {
  implicit val catShow: Show[Cat] = 
    Show.show { cat =>
      val name = cat.name
      val age = cat.age
      val color = cat.color

      s"$name is a $age year-old $color cat."
    }

  implicit val catEq: Eq[Cat] = 
    Eq.instance[Cat] { (cat1, cat2) =>
      (cat1.name === cat2.name) &&
      (cat1.age === cat2.age) &&
      (cat1.color === cat2.color)
    }
}
