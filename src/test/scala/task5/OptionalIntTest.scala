package task5

import org.junit.*
import org.junit.Assert.*
import Optionals.*

class OptionalIntTest:
  @Test def emptyOptionalShouldBeEmpty(): Unit =
    val empty = OptionalInt.Empty()
    assertTrue(OptionalInt.isEmpty(empty))

  @Test def nonEmptyOptionalShouldNotBeEmpty(): Unit =
    val nonEmpty = OptionalInt.Just(0)
    assertFalse(OptionalInt.isEmpty(nonEmpty))

  @Test def orElseShouldReturnDefaultWhenEmpty(): Unit =
    val nonEmpty = OptionalInt.Just(0)
    assertEquals(0, OptionalInt.orElse(nonEmpty, 1))

  @Test def orElseShouldReturnValueWhenNonEmpty(): Unit =
    val empty = OptionalInt.Empty()
    assertEquals(1, OptionalInt.orElse(empty, 1))

  /** Task 5: do test for map **/
  @Test def mapIntShouldBeEmpty(): Unit =
    val empty = OptionalInt.Empty()
    assertTrue(OptionalInt.isEmpty(OptionalInt.mapInt(empty)(_ + 3)))

  @Test def mapIntShouldReturnNewValue(): Unit =
    val notEmpty = OptionalInt.Just(1)
    assertEquals(OptionalInt.Just(4), OptionalInt.mapInt(notEmpty)(_ + 3))

  @Test def filterShouldReturnEmpty(): Unit =
    val empty = OptionalInt.Empty()
    assertTrue(OptionalInt.isEmpty(OptionalInt.filter(empty)(_ > 3)))

  @Test def filterShouldReturnValue(): Unit =
    val notEmpty = OptionalInt.Just(1)
    assertEquals(OptionalInt.Just(1), OptionalInt.filter(notEmpty)(_ < 3))

  @Test def filterShouldReturnEmptyIfPredicateIsFalse(): Unit =
    val notEmpty = OptionalInt.Just(1)
    assertEquals(OptionalInt.Empty(), OptionalInt.filter(notEmpty)(_ > 3))
