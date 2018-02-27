package scala_with_cats.printable

import scala_with_cats.Cat

// 1. Type class
trait Printable[A] {
  def format(value: A): String
}

// 2. Type instances
object PrintableInstances {
  implicit val stringPrinter: Printable[String] =
    new Printable[String] {
      def format(string: String) = string
    }

  implicit val intPrinter: Printable[Int] =
    new Printable[Int] {
      def format(int: Int) = int.toString
    }

  implicit val catPrinter: Printable[Cat] = 
    new Printable[Cat] {
      def format(cat: Cat) = {
        val name = cat.name
        val age = cat.age
        val color = cat.color

        s"$name is a $age year-old $color cat."
      }
    }
}

// 3. Type interface (using an interface object)
object Printable {
  def format[A](value: A)(implicit p: Printable[A]): String =
    p.format(value)

  def print[A](value: A)(implicit p: Printable[A]): Unit = 
    println(format(value))
}

