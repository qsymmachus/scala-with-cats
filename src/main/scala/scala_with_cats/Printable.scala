package scala_with_cats

// 1. Type class
trait Printable[A] {
  def format(value: A): String
}

// 2. Type instances
object PrintableInstances {
  val stringPrinter: Printable[String] =
    new Printable[String] {
      def format(string: String) = string
    }

  val intPrinter: Printable[Int] =
    new Printable[Int] {
      def format(int: Int) = int.toString
    }
}

// 3. Type interface (using an interface object)
object Printable {
  def format[A](value: A)(implicit p: Printable[A]): String =
    p.format(value)

  def print[A](value: A)(implicit p: Printable[A]): Unit = 
    println(p.format(value))
}

