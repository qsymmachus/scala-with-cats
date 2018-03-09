package scala_with_cats.monoid

import cats._
import cats.implicits._

object SuperAdder {
  def add[A](items: List[A])(implicit monoid: Monoid[A]): A =
    items.fold(monoid.empty)(_ |+| _)
}

