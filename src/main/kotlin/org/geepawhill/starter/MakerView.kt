package org.geepawhill.starter

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
                    model.setLocation("kitchen")
                }
            }
            button("living room") {
                action {
                    model.setLocation("living-room")
                }
            }
        }
        center = splitpane {
            this += locationView
            this += actionView
        }
    }

}