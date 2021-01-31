package com.example.myapplication.model

import java.io.Serializable

data class Screenshot(
    var height: Int?,
    var uri: String?,
    var url: String?,
    var width: Int?
): Serializable