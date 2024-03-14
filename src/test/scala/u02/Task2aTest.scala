package u02

import org.junit.*
import org.junit.Assert.*
import u02.Task2a.*

class Task2aTest:

    val pos: String = "positive"
    val neg: String = "negative"

    @Test def methodWorksTest() =
        assertEquals(positive(10), pos)
        assertEquals(positive(0), pos)
        assertEquals(positive(-5), neg)

    @Test def lambdaWorksTest() =
        assertEquals(positiveVal(10), pos)
        assertEquals(positiveVal(0), pos)
        assertEquals(positiveVal(-5), neg)

    @Test def lambdaAndMethodReturnSameOutput() =
        assertEquals(positive(10), positiveVal(10))
        assertEquals(positive(-1), positiveVal(-5))