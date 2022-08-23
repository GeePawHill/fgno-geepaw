package org.geepawhill.plotter.ui

import javafx.scene.Parent
import tornadofx.*


class MakerView() : View("Plotter") {

    val model = Model()
    val locationView = LocationView(model)
    val actionView = ActionView(model)

    override val root: Parent = borderpane {
        top = toolbar {
            button("kitchen") {
                action {
                    model.relocate("kitchen")
                }
            }
            button("living room") {
                action {
                    model.relocate("living-room")
                }
            }
        }
        center = splitpane {
            this += locationView
            this += actionView
        }
    }

}