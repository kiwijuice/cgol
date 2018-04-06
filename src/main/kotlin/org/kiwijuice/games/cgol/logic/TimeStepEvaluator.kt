package org.kiwijuice.games.cgol.logic

import org.kiwijuice.games.cgol.Cell
import org.kiwijuice.games.cgol.Grid

class TimeStepEvaluator {
    companion object {

        val UNDERPOPULATION = 1
        val OVERPOPULATION = 4
        val LIVE_NEIGHBORS_FOR_REPRODUCTION = 3

        fun evaluateIsAlive(cell: Cell, noOfLiveNeighbors: Int): Boolean {
            if (cell.isLive) {
                return (noOfLiveNeighbors > UNDERPOPULATION && noOfLiveNeighbors < OVERPOPULATION)
            } else {
                return (noOfLiveNeighbors == LIVE_NEIGHBORS_FOR_REPRODUCTION)
            }
        }

        fun evaluteNextGrid(grid: Grid): Grid {
            val nextGrid = Grid(grid.width, grid.height)

            for (cell in grid) {
                val liveNeighbors = CellEnvironment.findNeighborCells(cell, grid).count { c -> c.isLive }
                val isAlive = evaluateIsAlive(cell, liveNeighbors)

                nextGrid[cell.x, cell.y] = isAlive
            }

            return nextGrid
        }
    }
}
