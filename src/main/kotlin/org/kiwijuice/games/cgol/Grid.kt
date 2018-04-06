package org.kiwijuice.games.cgol

private typealias BooleanMatrix = Array<BooleanArray>

/**
 * Initializes a grid with dead cells.
 * @param width The width of the grid (no. of cells).
 * @param height The height of the grid (no. of cells).
 */
class Grid(val width:Int, val height:Int) : Iterable<Cell> {

    /**
     * Implements iterator over all the cells in a grid.
     */
    class GridIterator(private val grid: Grid) : Iterator<Cell>  {

        private var cursor = 0
        private val numberOfCells = grid.width * grid.height

        override fun hasNext(): Boolean {
            return cursor < numberOfCells
        }

        override fun next(): Cell {
            val y = cursor / grid.width
            val x = cursor % grid.width

            cursor++
            return grid[x, y]
        }
    }

    /**
     * Holds the state (alive or dead) of each cell in the grid.
     */
    private var cellsStateMatrix: BooleanMatrix = Array(height, {
        BooleanArray(width)
    })

    /**
     * Returns a grid iterator over the cells in the grid.
     * @return A grid iterator over the cells in the grid.
     */
    override fun iterator(): Iterator<Cell> {
        return GridIterator(this)
    }

    /**
     * Returns the cell located in position (x, y)
     * @param x The horizontal position of the cell.
     * @param y The vertical position of the cell.
     * @return The cell located in the given position.
     */
    operator fun get(x: Int, y:Int): Cell {

        if (x < 0 || y < 0) {
            throw IndexOutOfBoundsException("Indexes must be greater than zero")
        }

        if (x >= width || y >= height) {
            throw IndexOutOfBoundsException("Index must be in the size of the array")
        }

        return Cell(cellsStateMatrix[y][x], x, y)
    }

    /**
     * Sets the status (alive or dead) of the cell located in position (x, y)
     * @param x The horizontal position of the cell.
     * @param y The vertical position of the cell.
     * @param alive Sets the status of the cell.
     */
    operator fun set(x: Int, y: Int, alive: Boolean) {

        if (x < 0 || y < 0) {
            throw IndexOutOfBoundsException("Indexes must be greater than zero")
        }

        if (x >= width || y >= height) {
            throw IndexOutOfBoundsException("Index must be in the size of the array")
        }

        cellsStateMatrix[y][x] = alive
    }
}