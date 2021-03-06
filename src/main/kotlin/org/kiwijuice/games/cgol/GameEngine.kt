package org.kiwijuice.games.cgol

import org.kiwijuice.games.cgol.logic.TimeStepEvaluator
import org.kiwijuice.games.cgol.visualization.GridVisualizer

/**
 * Initializes an engine that simulates the evolution of the cells.
 * @param grid The seed.
 * @param stepSpeedMs The time it takes for the evolution to go from one step to the next in ms.
 * @param visualizer The component responsible for printing the grid to the screen.
 */
class GameEngine(private var grid: Grid,
                 private val stepSpeedMs: Long,
                 private val visualizer: GridVisualizer) : Runnable {

    private var running = true

    override fun run() {

        var step = 0

        while (running) {
            visualizer.printGrid(grid, step++)
            Thread.sleep(stepSpeedMs)
            grid = TimeStepEvaluator.evaluteNextGrid(grid)
        }
    }

    fun stop() {
        running = false
    }

}
