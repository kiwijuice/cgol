package org.kiwijuice.games.cgol

import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class GridTest {

    @Test
    fun iterator_ifCellIsNotTheLastOne_hasNextReturnsTrue() {
        val grid = Grid(1, 1)

        val iterator = grid.iterator()

        assertTrue(iterator.hasNext(), "Iterator.hasNext should return true if it did not iterate on all the cells.")
    }

    @Test
    fun iterator_ifCellIsLastOne_hasNextReturnsFalse() {
        val grid = Grid(1, 1)

        val iterator = grid.iterator()
        iterator.next()

        assertFalse(iterator.hasNext(), "Iterator.hasNext should return false when reaching the last cell.")
    }
}