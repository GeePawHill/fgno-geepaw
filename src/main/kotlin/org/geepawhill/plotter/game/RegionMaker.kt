package org.geepawhill.plotter.game

class RegionMaker(
    val parentKey: Key,
    var key: Key = Fact.next("Region"),
    private val holder: ActionHolder = Actions()
) : FactMaker<Region>, ActionHolder by holder {
    val siteMakers = mutableSetOf<SiteMaker>()

    override fun make(world: World): Region {
        val sites = Facts<Site>()
        siteMakers.forEach {
            sites += it.make(world)
        }
        val region = Region(Fact.combine(parentKey, key), sites, holder)
        world.add(region)
        return region
    }

    fun site(siteKey: Key = Fact.next("S"), details: SiteMaker.() -> Unit = {}) {
        val maker = SiteMaker(Fact.combine(parentKey, key), siteKey)
        maker.details()
        siteMakers.add(maker)
    }
}