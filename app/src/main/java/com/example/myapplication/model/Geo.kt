package com.example.myapplication.model

import java.io.Serializable

data class Geo(
    var area: String?,
    var city: String?,
    var country: String?,
    var lat: Double?,
    var lon: Double?,
    var metro: String?,
    var postalcode: String?,
    var region: String?
): Serializable