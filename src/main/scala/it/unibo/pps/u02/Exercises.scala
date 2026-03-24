package it.unibo.pps.u02

import it.unibo.pps.u02.Exercises.Expr.{Literal, Add, Multiply}

object Exercises extends App {

  def lessAndEqual(x: Double, y: Double, z: Double): Boolean = x <= y && y == z
  def lessAndEqualCurried(x: Double)(y: Double)(z: Double): Boolean = x <= y && y == z

  println(lessAndEqual(1, 2, 3)) // false
  println(lessAndEqual(1, 2, 2)) // true
  println(lessAndEqualCurried(1)(2)(3)) // false
  println(lessAndEqualCurried(1)(2)(2)) // true

  val lessAndEqualVal: (Double, Double, Double) => Boolean = (x, y, z) => x <= y && y == z
  val lessAndEqualCurrying: Double => Double => Double => Boolean = x => y => z => x <= y && y == z

  println(lessAndEqualVal(1, 2, 3)) // false
  println(lessAndEqualVal(1, 2, 2)) // true
  println(lessAndEqualCurrying(1)(2)(3)) // false
  println(lessAndEqualCurrying(1)(2)(2)) // true

  def compose(f: Int => Int, g: Int => Int): Int => Int = x => f(g(x))

  println(compose(_ - 1, _ * 2)(5)) //9
  println(compose(_ - 2, _ * 3)(5 - 2)) //7

  def power(base: Double, exponent: Int): Double =
    @annotation.tailrec
    def tailPower(base: Double, exponent: Int, total: Double): Double = exponent match
      case 0 => total
      case _ => tailPower(base, exponent - 1, base * total)
    tailPower(base, exponent, 1)

  println(power(5, 2)) //25
  println(power(2, 5)) //32
  println(power(5, 0)) //1

  def reverseNumber(n: Int): Int =
    @annotation.tailrec
    def accumulator(remaining: Int, acc: Int): Int = remaining match
      case 0 => acc
      case _ => accumulator(remaining / 10, acc * 10 + remaining % 10)
    accumulator(n, 0)

  println(reverseNumber(12345))
  println(reverseNumber(1234567890))

  enum Expr:
    case Literal(constant: Int)
    case Add(x: Expr, y: Expr)
    case Multiply(x: Expr, y: Expr)

  object Expr:
    def evaluate(expr: Expr): Int = expr match
      case Literal(constant) => constant
      case Add(x, y) => evaluate(x) + evaluate(y)
      case Multiply(x, y) => evaluate(x) + evaluate(y)

    def show(expr: Expr): String = expr match
      case Literal(constant) => "" + constant
      case Add(x, y) => "(" + show(x) + " + " + show(y) + ")"
      case Multiply(x, y) => "(" + show(x) + " * " + show(y) + ")"

  val expr: Expr = Add(Literal(8), Multiply(Literal(2), Literal(3))) //8 + 2 * 3 = 13
  println(Expr.evaluate(expr))
  println(Expr.show(expr))

}
