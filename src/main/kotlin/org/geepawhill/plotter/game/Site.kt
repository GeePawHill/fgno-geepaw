package org.geepawhill.plotter.game

data class Site(override val key: Key, val locations: Facts<Location> = Facts()) : Fact