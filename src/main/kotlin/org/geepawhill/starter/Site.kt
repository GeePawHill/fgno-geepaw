package org.geepawhill.starter

data class Site(override val key: Key, val locations: Set<Location> = emptySet()) : Fact