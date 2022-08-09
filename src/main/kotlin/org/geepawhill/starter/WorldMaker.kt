package org.geepawhill.starter

class WorldMaker {

    private val regions = Facts<Region>()

    fun make(): World {
        val world = World()
        regions.forEach {
            it.sites.forEach {
                it.locations.forEach {
                    world.add(it)
                }
                world.add(it)
            }
            world.add(it)
        }
        return world
    }

    fun region(key: Key = Fact.next("R"), details: RegionMaker.() -> Unit = {}) {
        val maker = RegionMaker("geography", key)
        maker.details()
        val region = maker.make()
        regions.add(region)
    }
}