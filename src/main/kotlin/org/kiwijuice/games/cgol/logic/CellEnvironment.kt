package org.kiwijuice.games.cgol.logic

import org.kiwijuice.games.cgol.Cell
import org.kiwijuice.games.cgol.Grid

class CellEnvironment {

    companion object {

        /**
         * Find all the neighbors of a cell in the grid.
         * If the cell is located on one of the walls of the grid, the method will return
         * all the available neighbors.
         */
        fun findNeighborCells(cell: Cell, grid: Grid): Array<Cell> {

            if (cell.x < 0 || cell.y < 0) {
                throw IndexOutOfBoundsException("Indexes must be greater than zero")
            }

            if (cell.x >= grid.width || cell.y >= grid.height) {
                throw IndexOutOfBoundsException("Index must be in the size of the array")
            }

            val neighborCells = mutableListOf<Cell>()

            for (i in cell.x - 1 .. cell.x + 1) {
                for (j in cell.y - 1 .. cell.y + 1) {
                    val indexesAreInGrid = i >= 0 && j >= 0 && i < grid.width && j< grid.width
                    val isCurrentCell = i == cell.x && j == cell.y

                    if (indexesAreInGrid && !isCurrentCell) {
                        neighborCells.add(grid[i, j])
                    }
                }
            }

            return neighborCells.toTypedArray()
        }
    }
}