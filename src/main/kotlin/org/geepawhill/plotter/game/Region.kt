package org.geepawhill.plotter.game

data class Region(
    override val key: Key,
    val sites: Facts<Site> = Facts(),
    private val holder: ActionHolder = Actions()
) : Fact, ActionHolder by holder