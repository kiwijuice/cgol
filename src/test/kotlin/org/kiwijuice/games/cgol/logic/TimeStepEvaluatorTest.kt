package org.kiwijuice.games.cgol.logic

import org.junit.Test
import org.kiwijuice.games.cgol.Cell
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class TimeStepEvaluatorTest {

    @Test
    fun evaluteIsAlive_inCellHasTwoLiveNeighbors_cellStaysAlive() {
        val liveNeighbors = 2
        val isAlive = TimeStepEvaluator.evaluateIsAlive(Cell(true, 3, 3), liveNeighbors)
        assertTrue(isAlive)
    }

    @Test
    fun evaluteIsAlive_inCellHasThreeLiveNeighbors_cellStaysAlive() {
        val liveNeighbors = 3
        val isAlive = TimeStepEvaluator.evaluateIsAlive(Cell(true, 3, 3), liveNeighbors)
        assertTrue(isAlive)
    }

    @Test
    fun evaluteIsAlive_ifUnderpopulated_cellIsNotAlive() {
        val liveNeighbors = 1
        val isAlive = TimeStepEvaluator.evaluateIsAlive(Cell(true, 3, 3), liveNeighbors)
        assertFalse(isAlive)
    }


    @Test
    fun evaluteIsAlive_ifOverpopulated_cellIsNotAlive() {
        val liveNeighbors = 4
        val isAlive = TimeStepEvaluator.evaluateIsAlive(Cell(true, 3, 3), liveNeighbors)
        assertFalse(isAlive)
    }

    @Test
    fun evaluteIsAlive_ifCellIsDeadAndHasThreeLiveNeighbors_cellIsAlive() {
        val liveNeighbors = 3
        val isAlive = TimeStepEvaluator.evaluateIsAlive(Cell(false, 3, 3), liveNeighbors)
        assertTrue(isAlive)
    }

    @Test
    fun evaluteIsAlive_ifCellIsDeadAndDoesNotHaveLiveNeighbors_cellStaysDead() {
        val liveNeighbors = 2
        val isAlive = TimeStepEvaluator.evaluateIsAlive(Cell(false, 3, 3), liveNeighbors)
        assertFalse(isAlive)
    }
}
