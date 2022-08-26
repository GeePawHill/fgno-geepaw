package org.geepawhill.plotter.game

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class KeyTest {

    @Test
    fun `suffix returns last part of key`() {
        val key ="a.b.c.d"
        assertThat(key.suffix()).isEqualTo("d")
    }

    @Test
    fun `noCategory returns tail of key`() {
        val key = "a.b.c.d"
        assertThat(key.noCategory()).isEqualTo("b.c.d")
    }
}