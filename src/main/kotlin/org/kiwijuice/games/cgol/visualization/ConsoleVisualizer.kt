package org.kiwijuice.games.cgol.visualization

import org.kiwijuice.games.cgol.Grid

private val CLEAR_CONSOLE_CHARACTERS = "\u001b[H\u001b[2J"

private val ALIVE_CELL_REPRESENTATION = "<#>"
private val DEAD_CELL_REPRESENTATION = "   "
private val HORIZONTAL_WALL_UNIT = "---"
private val VERTICAL_WALL_UNIT = "|"

class ConsoleVisualizer : GridVisualizer {

    override fun printGrid(grid: Grid, stepNumber: Int) {
        clearConsole()

        printStepNumber(stepNumber)
        printWallRow(grid)

        for (y in 0 until grid.height) {
            printCellsRow(grid, y)
        }

        printWallRow(grid)
    }

    private fun clearConsole() = print(CLEAR_CONSOLE_CHARACTERS)

    private fun printStepNumber(stepNumber: Int) = println("Current step: $stepNumber")

    private fun printWallRow(grid: Grid) {
        print(VERTICAL_WALL_UNIT)

        for (i in 0 until grid.width) {
            print(HORIZONTAL_WALL_UNIT)
        }

        println(VERTICAL_WALL_UNIT)
    }

    private fun printCellsRow(grid: Grid, y: Int) {
        print(VERTICAL_WALL_UNIT)

        for (x in 0 until grid.width) {
            printCell(grid[x, y].isLive)
        }

        println(VERTICAL_WALL_UNIT)
    }

    private fun printCell(isLive: Boolean) {
        if (isLive) {
            print(ALIVE_CELL_REPRESENTATION)
        } else {
            print(DEAD_CELL_REPRESENTATION)
        }
    }
}
