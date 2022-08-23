package org.geepawhill.starter

data class Location(override val key: Key) : Fact {
    val actions = listOf<Action>(DumbAction("Action:$key"))
}