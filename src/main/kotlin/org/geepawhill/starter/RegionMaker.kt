package org.geepawhill.starter

class RegionMaker(val parentKey: Key, var key: Key = Fact.next("Region")) {
    private val sites = Facts<Site>()

    fun make(): Region {
        return Region(Fact.combine(parentKey, key), sites)
    }

    fun site(siteKey: Key = Fact.next("S"), details: SiteMaker.() -> Unit = {}) {
        val maker = SiteMaker(Fact.combine(parentKey, key), siteKey)
        maker.details()
        val site = maker.make()
        sites.add(site)
    }
}