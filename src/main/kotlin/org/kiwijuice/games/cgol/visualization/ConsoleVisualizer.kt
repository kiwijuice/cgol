package org.kiwijuice.games.cgol.visualization

import org.kiwijuice.games.cgol.Grid

private val CLEAR_CONSOLE_CHARACTERS = "\u001b[H\u001b[2J"
private val ALIVE_CELL_REPRESENTATION = "<#>"
private val DEAD_CELL_REPRESENTATION = "   "

class ConsoleVisualizer : GridVisualizer {

    override fun printGrid(grid: Grid) {
        clearConsole()

        printWallRow(grid)

        for (y in 0 until grid.height) {
            printCellsRow(grid, y)
        }

        printWallRow(grid)
    }


    private fun clearConsole() {
        print(CLEAR_CONSOLE_CHARACTERS)
    }

    private fun printWallRow(grid: Grid) {
        print(" ")
        for (i in 0 until grid.width) {
            print("---")
        }
        println(" ")
    }

    private fun printCellsRow(grid: Grid, y: Int) {
        print("(")
        for (x in 0 until grid.width) {
            val cell = grid[x, y]
            printCell(cell.isLive)
        }
        println(")")
    }

    private fun printCell(isLive: Boolean) {
        if (isLive) {
            print(ALIVE_CELL_REPRESENTATION)
        } else {
            print(DEAD_CELL_REPRESENTATION)
        }
    }
}