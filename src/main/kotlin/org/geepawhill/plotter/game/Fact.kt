package org.geepawhill.plotter.game

interface Fact {
    val key: Key

    companion object {
        private var nextKey = 0

        fun next(prefix: String): String {
            return "${fixBlank(prefix)}-${nextKey++}"
        }

        fun reset() {
            nextKey = 0
        }

        private fun fixBlank(prefix: String): String {
            if (prefix.isBlank()) return "unknown"
            else return prefix
        }

        fun combine(parentKey: Key, childKey: Key): Key = "$parentKey.$childKey"

    }
}