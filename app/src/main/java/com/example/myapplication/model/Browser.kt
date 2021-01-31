package com.example.myapplication.model

import java.io.Serializable

data class Browser(
    var appCodeName: String?,
    var appMinorVersion: String?,
    var appName: String?,
    var appVersion: String?,
    var browserLanguage: String?,
    var buildID: String?,
    var cookieEnabled: Boolean?,
    var cpuClass: String?,
    var doNotTrack: String?,
    var language: String?,
    var maxTouchPoints: Int?,
    var msDoNotTrack: String?,
    var msManipulationViewsEnabled: Boolean?,
    var msMaxTouchPoints: Int?,
    var msPointerEnabled: Boolean?,
    var onLine: Boolean?,
    var oscpu: String?,
    var platform: String?,
    var pointerEnabled: Boolean?,
    var product: String?,
    var productSub: String?,
    var standalone: Boolean?,
    var systemLanguage: String?,
    var userAgent: String?,
    var userLanguage: String?,
    var vendor: String?,
    var vendorSub: String?
): Serializable