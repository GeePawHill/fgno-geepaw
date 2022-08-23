package org.geepawhill.plotter.game


interface Action {
    val shortDescribe: String
    fun act(changer:WorldChanger)
}