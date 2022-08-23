package org.geepawhill.starter

import javafx.beans.property.SimpleObjectProperty
import tornadofx.*


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

    fun setLocation(key: Key) {
        val location = world[key] as Location
        actions.clear()
        for (action in location.actions) {
            actions.add(action)
        }
    }
}
