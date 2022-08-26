package org.geepawhill.plotter.game

data class Location(override val key: Key,val holder: ActionHolder=Actions()) : Fact,ActionHolder by holder {
    val siteKey:Key = key.substringBeforeLast(".")
}