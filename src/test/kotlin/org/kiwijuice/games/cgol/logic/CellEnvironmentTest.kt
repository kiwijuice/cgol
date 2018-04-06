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
    fun findNeighborCells_ifCellPositionIsOutOfGrid_throwsException() {
        val grid = Grid(10, 10)
        val cell = Cell(true, 10, 0)
        CellEnvironment.findNeighborCells(cell, grid)
    }
}