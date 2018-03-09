package scala_with_cats.monoid

import cats._

/** Defines some Monoid instances. */
object Boolean {
  implicit val booleanAndMonoid: Monoid[Boolean] =
    new Monoid[Boolean] {
      def combine(a: Boolean, b: Boolean): Boolean = a && b

      def empty: Boolean = true
    }

  implicit val booleanOrMonoid: Monoid[Boolean] =
    new Monoid[Boolean] {
      def combine(a: Boolean, b: Boolean): Boolean = a || b

      def empty: Boolean = false

    }

  implicit def setUnionMonoid[A]: Monoid[Set[A]] =
    new Monoid[Set[A]] {
      def combine(a: Set[A], b: Set[A]): Set[A] = a union b

      def empty: Set[A] = Set.empty[A]
    }
}

