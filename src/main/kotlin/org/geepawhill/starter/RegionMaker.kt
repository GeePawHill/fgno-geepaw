package org.geepawhill.starter

class RegionMaker(val parentKey: Key, var key: Key = Fact.next("Region")) : FactMaker<Region> {
    val siteMakers = mutableSetOf<SiteMaker>()

    override fun make(world: World): Region {
        val sites = Facts<Site>()
        siteMakers.forEach {
            sites += it.make(world)
        }
        val region = Region(Fact.combine(parentKey, key), sites)
        world.add(region)
        return region
    }

    fun site(siteKey: Key = Fact.next("S"), details: SiteMaker.() -> Unit = {}) {
        val maker = SiteMaker(Fact.combine(parentKey, key), siteKey)
        maker.details()
        siteMakers.add(maker)
    }
}