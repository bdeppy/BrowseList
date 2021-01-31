package com.example.myapplication.model

import java.io.Serializable

data class Screen(
    var availHeight: Int?,
    var availLeft: Int?,
    var availTop: Int?,
    var availWidth: Int?,
    var bufferDepth: Int?,
    var colorDepth: Int?,
    var deviceXDPI: Int?,
    var deviceYDPI: Int?,
    var fontSmoothingEnabled: Boolean?,
    var height: Int?,
    var left: Int?,
    var logicalXDPI: Int?,
    var logicalYDPI: Int?,
    var mozOrientation: String?,
    var pixelDepth: Int?,
    var systemXDPI: Int?,
    var systemYDPI: Int?,
    var top: Int?,
    var updateInterval: Int?,
    var width: Int?
): Serializable