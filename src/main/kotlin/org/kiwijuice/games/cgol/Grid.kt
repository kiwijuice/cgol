package org.kiwijuice.games.cgol
private typealias CellGrid = Array<BooleanArray>

class Grid(val width:Int, val height:Int) : Iterable<Cell> {

    class GridIterator(val grid: Grid) : Iterator<Cell>  {

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

    override fun iterator(): Iterator<Cell> {
        return GridIterator(this)
    }

    var cellGrid: CellGrid = Array(height, {
        BooleanArray(width)
    })

    operator fun get(x: Int, y:Int): Cell {

        if (x < 0 || y < 0) {
            throw IndexOutOfBoundsException("Indexes must be greater than zero")
        }

        if (x >= width || y >= height) {
            throw IndexOutOfBoundsException("Index must be in the size of the array")
        }

        return Cell(cellGrid[y][x], x, y)
    }

    operator fun set(x: Int, y: Int, isLive: Boolean) {

        if (x < 0 || y < 0) {
            throw IndexOutOfBoundsException("Indexes must be greater than zero")
        }

        if (x >= height || y >= width) {
            throw IndexOutOfBoundsException("Index must be in the size of the array")
        }

        cellGrid[y][x] = isLive
    }

    fun printGrid() {
        cellGrid.forEach { row ->

            print("(")
            row.forEach {
                column -> printCell(column)
            }

            println(")")
        }
    }

    private fun printCell(isLive: Boolean) {
        if (isLive) {
            print("<#>")
        } else {
            print("   ")
        }
    }
}