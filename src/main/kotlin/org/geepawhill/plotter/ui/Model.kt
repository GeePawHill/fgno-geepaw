package org.geepawhill.plotter.ui

import javafx.beans.property.SimpleObjectProperty
import org.geepawhill.plotter.game.*
import tornadofx.*


class Model : WorldChanger {

    val world = world {
        region("region") {
            site("haiku") {
                location("kitchen") {
                    actions+= MoveAction("living-room")
                }
                location("living-room") {
                    actions+= MoveAction("kitchen")
                }
            }
        }
    }

    val start = world["kitchen"] as Location

    val location = SimpleObjectProperty<Location>(start)

    val actions = observableListOf<Action>()

    override fun relocate(key: Key) {
        val found = world[key] as Location
        actions.clear()
        for (action in found.actions) {
            actions.add(action)
        }
        location.value = found
    }
}
