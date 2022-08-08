package org.geepawhill.starter

class SiteMaker(val parentKey: Key, var key: String = Fact.next("S")) {
    private val locations = mutableSetOf<Location>()

    fun make(): Site {
        return Site(Fact.combine(parentKey, key), locations)
    }

    fun location(locationKey: Key = Fact.next("L"), details: LocationMaker.() -> Unit = {}) {
        val maker = LocationMaker(Fact.combine(parentKey, key), locationKey)
        maker.details()
        val location = maker.make()
        locations.add(location)
    }
}