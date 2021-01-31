package com.example.myapplication.model

import java.io.Serializable

data class Images(
    var cropped: Cropped?,
    var detail: Detail?,
    var full_image: FullImage?,
    var grid: Grid?,
    var list: List?,
    var no_context: NoContext?,
    var screenshot: Screenshot?,
    var thumbnail: Thumbnail?
):Serializable