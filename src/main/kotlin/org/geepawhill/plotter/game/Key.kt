package org.geepawhill.plotter.game

typealias Key = String

fun Key.suffix():Key {
    return this.substringAfterLast(".")
}