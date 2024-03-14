package u02

import org.junit.*
import org.junit.Assert.*
import u02.Task3b.*

class Task3bTest:

    @Test def emptyWorksCorrectlyTest() =
        assertTrue(empty(""))
        assertFalse(empty("ciao"))

    
    @Test def negEmptyWorksCorrectlyTest() =
        assertFalse(negEmpty(""))