package org.geepawhill.plotter.game

import org.assertj.core.api.Assertions.assertThat
import org.geepawhill.plotter.game.world
import org.junit.jupiter.api.Test

class WorldMakerTest {

    @Test
    fun `makes a simple world`() {
        val world = world {
            region("someRegion") {
                site("someSite") {
                    location("someLocation")
                }
            }
        }
        world.dump()
        assertThat(world.knows("geography.someRegion")).isTrue()
        assertThat(world.knows("geography.someRegion.someSite")).isTrue()
        assertThat(world.knows("geography.someRegion.someSite.someLocation")).isTrue()
    }

}