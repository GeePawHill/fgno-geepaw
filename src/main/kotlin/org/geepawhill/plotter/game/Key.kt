package org.geepawhill.plotter.game

typealias Key = String

fun Key.suffix():Key {
    return this.substringAfterLast(".")
}

fun Key.noCategory():Key {
    return this.substringAfter(".")
}