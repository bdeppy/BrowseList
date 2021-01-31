package com.example.myapplication.model

import java.io.Serializable


data class Item(
    var browser: Browser?,
    var campaign: ArrayList<Any>?,
    var comment: String?,
    var comments: ArrayList<Comment>?,
    var computed_browser: ComputedBrowser?,
    var computed_location: String?,
    var creation_date: Int?,
    var custom: Any?,
    var email: String?,
    var geo: Geo?,
    var host: String?,
    var html_snippet: Any?,
    var id: String?,
    var images: Images?,
    var integrations_sent: IntegrationsSent?,
    var ip: String?,
    var labels: ArrayList<String>?,
    var nps: Any?,
    var original_size: Any?,
    var performance: Int?,
    var public_id: String?,
    var rating: Int?,
    var screen: Screen?,
    var site_id: String?,
    var starred: Boolean?,
    var status: String?,
    var tags: ArrayList<String>?,
    var timing: Any?,
    var url: String?,
    var viewport: Viewport?
): Serializable