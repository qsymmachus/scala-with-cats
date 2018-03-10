package scala_with_cats.printable

import scala_with_cats.cat.Cat

/** 1. Type class */
trait Printable[A] {
  self =>

  def format(value: A): String

  /** Contramap! See "Scala with Cats" 3.6.1 */
  def contramap[B](func: B => A): Printable[B] =
    new Printable[B] {
      def format(value: B): String =
        self.format(func(value))
    }
}

/** 2. Type instances */
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

/** 3a. Type interface (using an interface object) */
object Printable {
  def format[A](value: A)(implicit p: Printable[A]): String =
    p.format(value)

  def print[A](value: A)(implicit p: Printable[A]): Unit = 
    println(format(value))
}


/** 
 *  3b. Type interface (using extension methods)
 *
 *  Allows you to do this:
 *
 *    cat.print
 */
object PrintableSyntax {
  implicit class PrintableOps[A](value: A) {
    def format(implicit p: Printable[A]): String =
      p.format(value)

    def print(implicit p: Printable[A]): Unit =
      println(p.format(value))
  }
}

