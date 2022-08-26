package org.geepawhill.plotter.game

data class Site(override val key: Key, val locations: Facts<Location> = Facts(), private val holder:ActionHolder = Actions()) : Fact, ActionHolder by holder