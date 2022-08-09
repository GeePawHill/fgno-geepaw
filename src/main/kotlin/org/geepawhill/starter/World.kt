package org.geepawhill.starter


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
        addFact(location)
        locations.add(location)
    }

    fun add(region: Region) {
        addFact(region)
        regions.add(region)
    }

    fun add(site: Site) {
        addFact(site)
        sites.add(site)
    }

    fun addFact(fact: Fact) {
        if (all.filter { it.key == fact.key }
                .isNotEmpty()) throw RuntimeException("The long key [${fact.key} already exists.")
        all.add(fact)
    }

    fun knows(fact: Fact): Boolean {
        return all.contains(fact)
    }

    fun knows(key: Key): Boolean {
        return all.map { it.key }.contains(key)
    }

    operator fun get(key: Key): Fact {
        val result = mutableSetOf<Fact>()
        all.forEach {
            if (it.key == key) result += it
            if (it.key.endsWith(key)) result += it
        }
        if (result.isEmpty()) throw RuntimeException("No such fact: [$key]")
        if (result.size > 1) throw RuntimeException("Ambiguous key: [$key]")
        return result.first()!!
    }

    fun dump() {
        for (site in sites) println(site)
        for (region in regions) println(region)
        for (location in locations) println(location)
    }
}


