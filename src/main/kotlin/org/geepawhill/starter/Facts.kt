package org.geepawhill.starter

class Facts<T : Fact> {
    private val facts = mutableMapOf<Key, T>()

    fun add(fact: T) {
        if (facts.contains(fact.key)) throw RuntimeException("Duplicate fact keys are not allowed. [${fact.key}]")
        facts[fact.key] = fact
    }

    operator fun get(key: Key): T {
        if (facts.contains(key)) return facts[key]!!
        val results = facts.keys.filter { it.endsWith(key) }
        if (results.isEmpty()) throw RuntimeException("No fact corresponds to key or shortkey [$key]")
        if (results.size > 1) throw RuntimeException("Ambiguous shortkey matches multiple facts [$key]")
        return facts[results.first()]!!
    }

}