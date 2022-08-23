package org.geepawhill.plotter.game

class MoveAction(destination:Key) : Action {
    override val shortDescribe = "Move: ${destination.suffix()}"

    override fun WorldChanger.act() {
        TODO("Not yet implemented")
    }

}
