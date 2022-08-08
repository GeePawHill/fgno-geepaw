package org.geepawhill.starter

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SiteMakerTest {

    @Test
    fun `makes correct key if siteKey supplied to maker`() {
        val maker = SiteMaker("region", "site")
        val site = maker.make()
        assertThat(site.key).isEqualTo("region.site")
    }

    @Test
    fun `makes default key if no siteKey supplied to maker or set in lambda`() {
        Fact.reset()
        val maker = SiteMaker("region")
        val site = maker.make()
        assertThat(site.key).isEqualTo("region.S-0")
    }

    @Test
    fun `makes correct location key if supplied to location function`() {
        val maker = SiteMaker("region", "site")
        maker.location("location")
        val site = maker.make()
        assertThat(site.locations.map { it.key }.first()).isEqualTo("region.site.location")
    }

    @Test
    fun `makes correct location key if supplied to location lambda`() {
        val maker = SiteMaker("region", "site")
        maker.location {
            key = "location"
        }
        val site = maker.make()
        assertThat(site.locations.map { it.key }.first()).isEqualTo("region.site.location")
    }


}