package org.geepawhill.starter

interface Command {
    val name: String
    val description: String

    fun execute()
}