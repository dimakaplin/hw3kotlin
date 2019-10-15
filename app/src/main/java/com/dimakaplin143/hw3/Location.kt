package com.dimakaplin143.hw3

class Location (
    val lat: Double = 0.0,
    val lng: Double = 0.0,
    val address: String = ""
) {
    fun getUriString(): String {
        return "geo:$lat,$lng"
    }
}


