package org.geepawhill.plotter.game

class LocationMaker(val parentKey: Key, var key: Key = Fact.next("Location")) : FactMaker<Location> {

    val routeMakers = mutableSetOf<RouteMaker>()
    val actions = Actions()

    override fun make(world: World): Location {
        val location = Location(Fact.combine(parentKey, key),actions)
        world.add(location)
        return location
    }

    fun route(key: Key) {
        actions+=MoveAction(key)
    }
}