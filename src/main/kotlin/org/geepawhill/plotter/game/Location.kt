package org.geepawhill.plotter.game

data class Location(override val key: Key,val holder: ActionHolder=Actions()) : Fact,ActionHolder by holder {
    val site:Key = key.substringBeforeLast(".")
    val region:Key = site.substringBeforeLast(".")
}