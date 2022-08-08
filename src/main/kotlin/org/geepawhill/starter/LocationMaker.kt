package org.geepawhill.starter

class LocationMaker(val parentKey: Key, var key: Key = Fact.next("Location")) {
    fun make(): Location {
        return Location(Fact.combine(parentKey, key))
    }
}