package org.geepawhill.starter

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LocationMakerTest {

    @Test
    fun `makes the key if supplied to the maker`() {
        val maker = LocationMaker("site", "location")
        val location = maker.make()
        assertThat(location.key).isEqualTo("site.location")
    }

    @Test
    fun `uses next key if not supplied or set inside`() {
        Fact.reset()
        val maker = LocationMaker("site")
        val location = maker.make()
        assertThat(location.key).isEqualTo("site.Location-0")
    }


}