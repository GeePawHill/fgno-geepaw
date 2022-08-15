package org.geepawhill.starter

import javafx.geometry.Pos
import javafx.scene.Parent
import javafx.scene.layout.Background
import javafx.scene.layout.BackgroundFill
import javafx.scene.paint.Color
import javafx.scene.text.Font
import tornadofx.*

class Styles {
    companion object {
        val DARK_BACKGROUND = Background(BackgroundFill(Color.DARKGRAY, null, null))
        val LARGE_FONT = Font.font(30.0)
    }
}

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

class ActionView : Fragment() {
    override val root: Parent = vbox {
        background = Styles.DARK_BACKGROUND
        minWidth = 300.0
        stackpane {
            label("Action") {
                font = Styles.LARGE_FONT
            }
        }
        vbox {
            alignment = Pos.CENTER
            button("Quit")
        }
    }
}


class MakerView() : View("Plotter") {

    val model = Model()
    val locationView = LocationView(model)
    val actionView = ActionView()

    override val root: Parent = borderpane {
        top = toolbar {
            button("change location") {
                action {
                    model.changeLocation()
                }
            }
        }
        center = splitpane {
            this += locationView
            this += actionView
        }
    }

}