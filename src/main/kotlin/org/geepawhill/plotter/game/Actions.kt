package org.geepawhill.plotter.game

class Actions : ActionHolder {
    override val actions = mutableSetOf<Action>()
    override fun add(action: Action) {
        actions.add(action)
    }

    override fun plusAssign(action: Action) {
        add(action)
    }

}