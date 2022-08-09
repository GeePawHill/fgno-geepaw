package org.geepawhill.starter


fun world(details: WorldMaker.() -> Unit = {}): World {
    val builder = WorldMaker()
    builder.details()
    return builder.make()
}

class World {
    private val all = Facts<Fact>()
    private val locations = Facts<Location>()
    private val regions = Facts<Region>()
    private val sites = Facts<Site>()

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
        all.add(fact)
    }

    fun knows(fact: Fact): Boolean {
        return all.contains(fact.key)
    }

    fun knows(key: Key): Boolean {
        return all.contains(key)
    }

    operator fun get(key: Key): Fact {
        return all[key]
    }

    fun dump() {
//        for (site in sites) println(site)
//        for (region in regions) println(region)
//        for (location in locations) println(location)
    }
}


