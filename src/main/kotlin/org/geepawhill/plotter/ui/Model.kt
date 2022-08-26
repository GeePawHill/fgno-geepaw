package org.geepawhill.plotter.ui

import javafx.beans.property.SimpleObjectProperty
import org.geepawhill.plotter.game.*
import tornadofx.*


class Model : WorldChanger {

    val world = world {
        region("another-world") {
            site("haiku") {
                location("kitchen") {
                    route("living-room")
                }
                location("living-room") {
                    route("kitchen")
                }
            }
        }
    }

    val start = world["kitchen"] as Location

    val location = SimpleObjectProperty<Location>()

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
