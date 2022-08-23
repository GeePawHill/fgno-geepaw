package org.geepawhill.plotter.game

class MoveAction(val destination:Key) : Action {
    override val shortDescribe = "Move: ${destination.suffix()}"


    override fun act(changer: WorldChanger) {
        with(changer) {
            relocate(destination)
        }
    }
}
