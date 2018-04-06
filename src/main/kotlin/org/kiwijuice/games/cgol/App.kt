package org.kiwijuice.games.cgol

var GRID_SIZE = 40

fun main(args: Array<String>) {
    println("Starting")

    var grid = Grid(GRID_SIZE, GRID_SIZE)

    grid[0, 10] = true


    val cell = grid[0, 0]
    CellEnvironment.findNeighborCells(cell, grid).forEach { c -> println(c) }


    // grid.printGrid()


}

