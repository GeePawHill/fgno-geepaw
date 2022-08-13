package org.geepawhill.starter

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LocationMakerTest {

    val world = World()

    @Test
    fun `makes the key if supplied to the maker`() {
        val maker = LocationMaker("site", "location")
        val location = maker.make(world)
        assertThat(location.key).isEqualTo("site.location")
    }

    @Test
    fun `uses next key if not supplied or set inside`() {
        Fact.reset()
        val maker = LocationMaker("site")
        val location = maker.make(world)
        assertThat(location.key).isEqualTo("site.Location-0")
    }

    @Test
    fun `uses key if set inside`() {
        val maker = LocationMaker("site")
        maker.key = "location"
        val location = maker.make(world)
        assertThat(location.key).isEqualTo("site.location")
    }

}