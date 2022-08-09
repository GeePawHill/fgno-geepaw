package org.geepawhill.starter

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WorldTest {

    @Test
    fun `finds short unique key for fact`() {
        val world = world {
            region("something")
            region("unique")
        }
        assertThat(world["unique"].key).isEqualTo("geography.unique")
    }

    @Test
    fun `throws on non-existent key`() {
        val world = world {
            region("something")
            region("unique")
        }
        assertThrows<RuntimeException> {
            val fact = world["nope"]
        }
    }

    @Test
    fun `throws on duplicate key`() {
        assertThrows<RuntimeException> {
            val world = world {
                region("something")
                region("something")
            }
        }
    }

    @Test
    fun `throws on ambiguous key`() {
        val world = world {
            region("something") {
                site("something")
            }
        }
        assertThrows<RuntimeException> {
            val fact = world["something"]
        }
    }
}