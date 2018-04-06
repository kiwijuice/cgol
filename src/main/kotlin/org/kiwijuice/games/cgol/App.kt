package org.kiwijuice.games.cgol

import org.kiwijuice.games.cgol.visualization.ConsoleVisualizer

private val GRID_SIZE = 50
private val STEP_SPEED_MS = 200L

fun main(args: Array<String>) {
    println("Starting")

    var grid = Grid(GRID_SIZE, GRID_SIZE)

    grid[31, 31] = true
    grid[32, 31] = true
    grid[30, 32] = true
    grid[31, 32] = true
    grid[31, 33] = true

    val visualizer = ConsoleVisualizer()
    GameEngine(grid, STEP_SPEED_MS, visualizer).run()
}

