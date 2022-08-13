package org.geepawhill.starter

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RegionMakerTest {

    val world = World()

    @Test
    fun `makes correct key if regionKey supplied to maker`() {
        val maker = RegionMaker("geography", "region")
        val region = maker.make(world)
        assertThat(region.key).isEqualTo("geography.region")
    }

    @Test
    fun `makes default key if no regionKey supplied to maker or set in lambda`() {
        Fact.reset()
        val maker = RegionMaker("geography")
        val region = maker.make(world)
        assertThat(region.key).isEqualTo("geography.Region-0")
    }

    @Test
    fun `makes correct site key if supplied to site function`() {
        val maker = RegionMaker("geography", "region")
        maker.site("site")
        val region = maker.make(world)
        assertThat(region.sites["geography.region.site"]).isNotNull
    }

    @Test
    fun `makes correct site key if assigned in site lambda`() {
        val maker = RegionMaker("geography", "region")
        maker.site {
            key = "site"
        }
        val region = maker.make(world)
        assertThat(region.sites["geography.region.site"]).isNotNull
    }
}