package com.example.myapplication.model

import java.io.Serializable

data class BrowserItemsModel(
    var count: Int?,
    var count_nolimit: Int?,
    var items: ArrayList<Item>?,
    var total: Int?
): Serializable