package org.kiwijuice.games.cgol

import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertNotNull
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

    @Test
    fun constructor_allCellsAreDead() {
        val grid = Grid(2, 2)

        for (cell in grid) {
            assertFalse(cell.isLive, "When grid is initialing all cells should be dead.")
        }
    }

    @Test
    fun get_ifPositionIsInGrid_returnsCell() {
        val grid = Grid(2, 2)
        val cell = grid[1, 1]

        assertNotNull(cell)
    }

    @Test(expected = IndexOutOfBoundsException::class)
    fun get_ifXPositionXIsNotInGrid_exepctionIsThrown() {
        val grid = Grid(2, 2)
        val cell = grid[0, 3]
    }

    @Test(expected = IndexOutOfBoundsException::class)
    fun get_ifPositionIsNegative_exepctionIsThrown() {
        val grid = Grid(2, 2)
        val cell = grid[-1, 0]
    }
}