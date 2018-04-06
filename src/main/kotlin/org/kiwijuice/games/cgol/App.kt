package org.kiwijuice.games.cgol

import org.kiwijuice.games.cgol.visualization.ConsoleVisualizer

val GRID_SIZE = 70

fun main(args: Array<String>) {
    println("Starting")

    var grid = Grid(GRID_SIZE, GRID_SIZE)

    grid[41, 41] = true
    grid[42, 41] = true
    grid[40, 42] = true
    grid[41, 42] = true
    grid[41, 43] = true



    val visualizer = ConsoleVisualizer()

    while (true) {

        visualizer.printGrid(grid)

        Thread.sleep(200)

        val nextGrid = Grid(GRID_SIZE, GRID_SIZE)

        for (cell in grid) {
            val liveNeighbors = CellEnvironment.findNeighborCells(cell, grid).count { c -> c.isLive }
            val isAlive = isAlive(cell, liveNeighbors)

            nextGrid[cell.x, cell.y] = isAlive
        }

        grid = nextGrid
    }
}

fun isAlive(cell: Cell, noOfLiveNeighbors: Int): Boolean {
    if (cell.isLive) {
        return (noOfLiveNeighbors == 2 || noOfLiveNeighbors == 3)
    } else {
        return (noOfLiveNeighbors == 3)
    }
}

