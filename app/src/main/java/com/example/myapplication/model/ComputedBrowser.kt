package com.example.myapplication.model

import java.io.Serializable

data class ComputedBrowser(
    var Browser: String?,
    var FullBrowser: String?,
    var Platform: String?,
    var Version: String?
): Serializable