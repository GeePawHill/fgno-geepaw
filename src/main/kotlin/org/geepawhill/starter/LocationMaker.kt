package org.geepawhill.starter

class LocationMaker(val parentKey: Key, var key: Key = Fact.next("Location")) : FactMaker<Location> {

    val routeMakers = mutableSetOf<RouteMaker>()

    override fun make(world: World): Location {
        val location = Location(Fact.combine(parentKey, key))
        world.add(location)
        return location
    }

    fun route(key: Key) {

    }
}