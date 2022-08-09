package org.geepawhill.starter

data class Region(override val key: Key, val sites: Facts<Site> = Facts()) : Fact