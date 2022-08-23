package org.geepawhill.starter

import javafx.scene.Parent
import tornadofx.*

class LocationView(val model: Model) : Fragment() {

    val locationLabel = label("Location") {
        font = Styles.LARGE_FONT
    }


    override val root: Parent = vbox {
        minWidth = 300.0
        background = Styles.DARK_BACKGROUND
        stackpane {
            this += locationLabel
        }
    }

    init {
        model.location.addListener { _, _, new ->
            locationLabel.text = new.key
        }
    }
}