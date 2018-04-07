package org.kiwijuice.games.cgol.visualization

import org.kiwijuice.games.cgol.Grid

interface GridVisualizer {
    fun printGrid(grid: Grid, step: Int)
}
