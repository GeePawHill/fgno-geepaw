package org.geepawhill.plotter.ui

import javafx.beans.property.SimpleObjectProperty
import org.geepawhill.plotter.game.Action
import org.geepawhill.plotter.game.Key
import org.geepawhill.plotter.game.Location
import org.geepawhill.plotter.game.world
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
        val found = world[key] as Location
        actions.clear()
        for (action in found.actions) {
            actions.add(action)
        }
        location.value = found
    }
}
