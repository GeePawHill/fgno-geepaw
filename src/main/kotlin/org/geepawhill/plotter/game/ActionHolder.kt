package org.geepawhill.plotter.game

interface ActionHolder {
    val actions: Set<Action>
    fun add(action:Action)
    operator fun plusAssign(action:Action)
    fun action(action:Action)
}

