package org.geepawhill.starter

data class Region(override val key: Key, val sites: Set<Site> = emptySet<Site>()) : Fact