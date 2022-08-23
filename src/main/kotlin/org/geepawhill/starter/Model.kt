package org.geepawhill.starter

import javafx.beans.property.SimpleObjectProperty
import tornadofx.*


interface Action {
    val shortName: String
}

class Model {

    val world = world {
        region("region") {
            site("haiku") {
                location("kitchen") {
                    route("living-room")
                }
                location("living-room")
            }
        }
    }

    val start = world["kitchen"] as Location

    val location = SimpleObjectProperty<Location>(start)

    val actions = observableListOf<Action>()

    class DumbAction(override val shortName: String) : Action {

    }

    fun changeAction1() {
        actions.clear()
        actions.add(DumbAction("Open door"))
        actions.add(DumbAction("Something else"))
    }

    fun changeAction2() {
        actions.clear()
        actions.add(DumbAction("Pick up key"))
        actions.add(DumbAction("Why you keep bugging me?"))
        actions.add(DumbAction("Here's One more"))
    }

    fun changeLocation() {
        location.set(world["living-room"] as Location)
    }
}
