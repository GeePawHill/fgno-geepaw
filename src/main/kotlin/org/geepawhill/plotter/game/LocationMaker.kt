package org.geepawhill.plotter.game

class LocationMaker(val parentKey: Key, var key: Key = Fact.next("Location")) : FactMaker<Location> {

    val routeMakers = mutableSetOf<RouteMaker>()
    val actions = mutableSetOf<Action>()

    override fun make(world: World): Location {
        val location = Location(Fact.combine(parentKey, key),actions.toList())
        world.add(location)
        return location
    }

    fun route(key: Key) {
        actions+=MoveAction(key)
    }
}