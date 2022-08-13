package org.geepawhill.starter

interface FactMaker<T> {
    fun make(world: World): T
}