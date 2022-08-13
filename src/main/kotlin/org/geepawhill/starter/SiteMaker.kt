package org.geepawhill.starter

class SiteMaker(val parentKey: Key, var key: String = Fact.next("Site")) {
    private val locationMakers = mutableSetOf<LocationMaker>()

    fun make(): Site {
        val locations = Facts<Location>()
        locationMakers.forEach { maker ->
            locations.add(maker.make())
        }
        return Site(Fact.combine(parentKey, key), locations)
    }

    fun location(locationKey: Key = Fact.next("L"), details: LocationMaker.() -> Unit = {}) {
        val maker = LocationMaker(Fact.combine(parentKey, key), locationKey)
        maker.details()
        locationMakers.add(maker)
    }
}