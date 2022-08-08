package org.geepawhill.starter

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FactTest {

    @Test
    fun `next makes next key`() {
        Fact.reset()
        assertThat(Fact.next("prefix")).isEqualTo("prefix-0")
        assertThat(Fact.next("prefix")).isEqualTo("prefix-1")
    }

    @Test
    fun `next handles empty prefix with unknown`() {
        Fact.reset()
        assertThat(Fact.next("")).isEqualTo("unknown-0")
    }

}