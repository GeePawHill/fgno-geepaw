package org.geepawhill.plotter.game


interface WorldChanger {

}

interface Action {
    val shortDescribe: String
    fun WorldChanger.act()
}