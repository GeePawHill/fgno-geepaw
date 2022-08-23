package org.geepawhill.plotter.game

class WorldMaker {

    private val regionMakers = mutableSetOf<RegionMaker>()

    fun make(): World {
        val world = World()
        regionMakers.forEach {
            it.make(world)
        }
        return world
    }

    fun region(key: Key = Fact.next("R"), details: RegionMaker.() -> Unit = {}) {
        val maker = RegionMaker("geography", key)
        maker.details()
        regionMakers.add(maker)
    }
}