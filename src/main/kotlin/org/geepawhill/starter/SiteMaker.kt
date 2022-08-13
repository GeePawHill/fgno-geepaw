package org.geepawhill.starter

class SiteMaker(val parentKey: Key, var key: String = Fact.next("Site")) : FactMaker<Site> {
    private val locationMakers = mutableSetOf<LocationMaker>()

    override fun make(world: World): Site {
        val locations = Facts<Location>()
        locationMakers.forEach {
            locations += it.make(world)
        }
        val site = Site(Fact.combine(parentKey, key), locations)
        world.add(site)
        return site
    }

    fun location(locationKey: Key = Fact.next("L"), details: LocationMaker.() -> Unit = {}) {
        val maker = LocationMaker(Fact.combine(parentKey, key), locationKey)
        maker.details()
        locationMakers.add(maker)
    }
}