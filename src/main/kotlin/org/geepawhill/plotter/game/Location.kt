package org.geepawhill.plotter.game

data class Location(override val key: Key, val actions:List<Action> = listOf<Action>()) : Fact {
}