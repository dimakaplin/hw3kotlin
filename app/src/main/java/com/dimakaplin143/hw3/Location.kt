package com.dimakaplin143.hw3

class Location (
    var lat: Double = 0.0,
    var lng: Double = 0.0
) {
    fun getUriString(): String {
        return "geo:$lat,$lng"
    }
}


