package org.geepawhill.plotter.game

import org.junit.jupiter.api.Test

class HaikuTest {

    @Test
    fun layoutHaiku() {
        val world = makeHaiku()
    }

    companion object {
        fun makeHaiku(): World {
            return world {
                region("another-world") {
                    site("access") {
                        location("side-drive")
                        location("parking")
                        location("woodpile")
                        location("back-porch")
                    }
                    site("haiku") {
                        location("entry")
                        location("kitchen")
                        location("bathroom")
                        location("living-room")
                        location("mail-room")
                        location("stairs")
                        location("loft")
                        location("ballroom")
                        location("deck")
                        location("master")
                        location("guest")
                        location("pit")
                    }
                }
            }
        }
    }
}