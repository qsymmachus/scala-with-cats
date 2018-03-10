package scala_with_cats.monoid

import cats._

case class Order(totalCost: Double, quantity: Double)

object Order {
  /** Order monoid, allows you to combine orders. */
  implicit val orderMonoid: Monoid[Order] =
    new Monoid[Order] {
      def combine(a: Order, b: Order): Order =
        Order(a.totalCost + b.totalCost, a.quantity + b.quantity)

      def empty: Order = Order(0.0, 0.0)
    }
}

