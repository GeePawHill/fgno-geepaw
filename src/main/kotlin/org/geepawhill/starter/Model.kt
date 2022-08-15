package org.geepawhill.starter

import javafx.beans.property.SimpleObjectProperty

class Model {

    val world = world {
        region("region") {
            site("haiku") {
                location("kitchen")
                location("living-room")
            }
        }
    }

    val start = world["kitchen"] as Location

    val location = SimpleObjectProperty<Location>(start)

    fun changeLocation() {
        location.set(world["living-room"] as Location)
    }

}
