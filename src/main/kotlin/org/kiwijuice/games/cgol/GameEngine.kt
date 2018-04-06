package org.kiwijuice.games.cgol

import org.kiwijuice.games.cgol.logic.TimeStepEvaluator
import org.kiwijuice.games.cgol.visualization.GridVisualizer

class GameEngine(private var grid: Grid,
                 private val stepSpeedMs: Long,
                 private val visualizer: GridVisualizer) {

    fun run() {
        while (true) {
            visualizer.printGrid(grid)
            Thread.sleep(stepSpeedMs)
            grid = TimeStepEvaluator.evaluteNextGrid(grid)
        }
    }

}
