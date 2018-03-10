package scala_with_cats

import cats.implicits._
import scala_with_cats.cat.Cat
import scala_with_cats.functor.Tree
import scala_with_cats.monoid.Order
import scala_with_cats.monoid.SuperAdder
import scala_with_cats.printable.PrintableInstances._
import scala_with_cats.printable.PrintableSyntax._

object Main extends App {
  def break(message: String): Unit = println(s"\n$message")

  break("Testing printing a Cat with Printable:")
  val toby = Cat("Toby", 4, "calico")
  val ralph = Cat("Ralph", 10, "orange")
  ralph.print

  break("Testing printing a Cat with Show:")
  println(ralph.show)

  break("Testing Eq with some Cats:")
  println(ralph === toby)

  break("Testing SuperAdder.add:")
  println(SuperAdder.add(List[Int](1, 2, 3)))
  println(SuperAdder.add(List[Option[Int]](Some(1), Some(2), Some(3))))
  
  break("Testing SuperAdder.add with Orders:")
  val order1 = Order(24.45, 2.0)
  val order2 = Order(13.87, 5.0)
  println(SuperAdder.add(List[Order](order1, order2)))

  break("Testing Tree.map:")
  val tree = Tree.branch(Tree.leaf(2), Tree.leaf(5))
  println(tree.map(_ * 2))
}
