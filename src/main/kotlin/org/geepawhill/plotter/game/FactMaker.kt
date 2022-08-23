package org.geepawhill.plotter.game

interface FactMaker<T> {
    fun make(world: World): T
}