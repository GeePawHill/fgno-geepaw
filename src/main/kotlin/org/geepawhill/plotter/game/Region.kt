package org.geepawhill.plotter.game

data class Region(override val key: Key, val sites: Facts<Site> = Facts()) : Fact