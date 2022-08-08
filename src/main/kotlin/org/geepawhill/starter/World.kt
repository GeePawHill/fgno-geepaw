package org.geepawhill.starter

data class Location(override val key: Key = Fact.next("L")) : Fact

data class Site(override val key: Key = Fact.next("S"), val locations: Set<Location> = emptySet()) : Fact

data class Region(override val key: Key, val sites: Set<Site> = emptySet<Site>()) : Fact


fun world(details: WorldMaker.() -> Unit = {}): World {
    val builder = WorldMaker()
    builder.details()
    return builder.make()
}

class World {
    private val all = mutableSetOf<Fact>()
    private val locations = mutableSetOf<Location>()
    private val regions = mutableSetOf<Region>()
    private val sites = mutableSetOf<Site>()

    fun add(location: Location) {
        all.add(location)
        locations.add(location)
    }

    fun add(region: Region) {
        all.add(region)
        regions.add(region)
    }

    fun add(site: Site) {
        all.add(site)
        sites.add(site)
    }

    fun knows(fact: Fact): Boolean {
        return all.contains(fact)
    }

    fun knows(key: Key): Boolean {
        return all.map { it.key }.contains(key)
    }

    operator fun get(key: Key): Fact {
        return all.filter { it.key == key }.first()!!
    }

    fun dump() {
        for (site in sites) println(site)
        for (region in regions) println(region)
        for (location in locations) println(location)
    }
}


