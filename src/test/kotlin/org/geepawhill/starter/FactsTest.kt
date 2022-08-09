package org.geepawhill.starter

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class FactsTest {

    val facts = Facts<Fact>()

    @Test
    fun `basic add-get works`() {
        val fact = Location("a")
        facts.add(fact)
        assertThat(facts["a"]).isEqualTo(fact)
    }

    @Test
    fun `missing get throws`() {
        assertThrows<RuntimeException> {
            facts["a"]
        }
    }

    @Test
    fun `no duplicate keys allowed`() {
        assertThrows<RuntimeException> {
            facts.add(Location("a"))
            facts.add(Location("a"))
        }
    }

    @Test
    fun `unambiguous get works`() {
        facts.add(Location("a.b"))
        facts.add(Location("a.c"))
        assertThat(facts["b"].key).isEqualTo("a.b")
    }

    @Test
    fun `ambiguous get fails`() {
        facts.add(Location("a.c"))
        facts.add(Location("b.c"))
        assertThrows<RuntimeException> {
            val fact = facts["c"]
        }
    }
}