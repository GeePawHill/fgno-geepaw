package org.geepawhill.plotter.ui

import javafx.geometry.Pos
import javafx.scene.Parent
import javafx.scene.control.Button
import org.geepawhill.plotter.game.Action
import tornadofx.*

class ActionView(val model: Model) : Fragment() {
    override val root: Parent = vbox {
        background = Styles.DARK_BACKGROUND
        minWidth = 600.0
        minHeight = 600.0
        stackpane {
            label("Action") {
                font = Styles.LARGE_FONT
            }
        }
        vbox {
            alignment = Pos.CENTER
            children.bind(model.actions) { it -> makeButtonFor(it) }
        }
    }

    fun makeButtonFor(action: Action): Button {
        val button = button(action.shortDescribe) {
            action {
                    action.act(model)
            }
        }
        return button
    }
}