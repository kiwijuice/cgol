package org.kiwijuice.games.cgol.logic


import org.junit.Test
import org.kiwijuice.games.cgol.Cell
import org.kiwijuice.games.cgol.Grid
import kotlin.test.assertEquals

class CellEnvironmentTest {

    @Test
    fun findNeighborCells_ifCellIsInTheMiddle_returns8Cells() {
        val grid = Grid(10, 10)
        val cell = Cell(true, 3, 3)
        val neighbors = CellEnvironment.findNeighborCells(cell, grid)

        assertEquals(8, neighbors.size)
    }

    @Test
    fun findNeighborCells_ifCellIsOnTheTopWall_returns5Cells() {
        val grid = Grid(10, 10)
        val cell = Cell(true, 3, 0)
        val neighbors = CellEnvironment.findNeighborCells(cell, grid)

        assertEquals(5, neighbors.size)
    }

    @Test
    fun findNeighborCells_ifCellIsOnTheBottomWall_returns5Cells() {
        val grid = Grid(10, 10)
        val cell = Cell(true, 3, 9)
        val neighbors = CellEnvironment.findNeighborCells(cell, grid)

        assertEquals(5, neighbors.size)
    }

    @Test
    fun findNeighborCells_ifCellIsOnTheLeftWall_returns5Cells() {
        val grid = Grid(10, 10)
        val cell = Cell(true, 0, 3)
        val neighbors = CellEnvironment.findNeighborCells(cell, grid)

        assertEquals(5, neighbors.size)
    }

    @Test
    fun findNeighborCells_ifCellIsOnTheRightWall_returns5Cells() {
        val grid = Grid(10, 10)
        val cell = Cell(true, 9, 3)
        val neighbors = CellEnvironment.findNeighborCells(cell, grid)

        assertEquals(5, neighbors.size)
    }

    @Test
    fun findNeighborCells_ifCellIsInTheCornet_returns3Cells() {
        val grid = Grid(10, 10)
        val cell = Cell(true, 0, 0)
        val neighbors = CellEnvironment.findNeighborCells(cell, grid)

        assertEquals(3, neighbors.size)
    }

    @Test(expected = IndexOutOfBoundsException::class)
    fun findNeightborCells_ifXPositionIsLessThanZero_throwsException() {
        val grid = Grid(10, 10)
        val cell = Cell(true, -1, 0)
        CellEnvironment.findNeighborCells(cell, grid)
    }

    @Test(expected = IndexOutOfBoundsException::class)
    fun findNeightborCells_ifYPositionIsLessThanZero_throwsException() {
        val grid = Grid(10, 10)
        val cell = Cell(true, 0, -1)
        CellEnvironment.findNeighborCells(cell, grid)
    }

    @Test(expected = IndexOutOfBoundsException::class)
    fun findNeighborCells_ifXPositionIsEqualsOrGreaterThanWidth_throwsException() {
        val width = 5
        val height = 10
        val grid = Grid(width, height)
        val cell = Cell(true, 5, 0)
        CellEnvironment.findNeighborCells(cell, grid)
    }

    @Test(expected = IndexOutOfBoundsException::class)
    fun findNeighborCells_ifYPositionIsEqualsOrGreaterThanHeight_throwsException() {
        val width = 10
        val height = 5
        val grid = Grid(width, height)
        val cell = Cell(true, 0, 5)
        CellEnvironment.findNeighborCells(cell, grid)
    }
}