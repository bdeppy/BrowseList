package com.exam.project.Exam.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.model.Item
import java.util.*

class BrowseViewHolder(viewGroup: ViewGroup) : RecyclerView.ViewHolder
    (
    LayoutInflater.from(viewGroup.context).inflate
        (R.layout.list_item_browse, viewGroup, false)
) {

    private val txtLabel by lazy { itemView.findViewById<TextView>(R.id.txtLabel) }
    private val txtPlatform by lazy { itemView.findViewById<TextView>(R.id.txtPlatform) }
    private val txtBrowserVersion by lazy { itemView.findViewById<TextView>(R.id.txtBrowserVersion) }
    private val txtGeoLocation by lazy { itemView.findViewById<TextView>(R.id.txtGeoLocation) }

    fun bindTo(browseItem: Item, activity: Activity) {

        if (browseItem.labels?.count() != 0 ){

            val text = browseItem.labels?.first()
            txtLabel.text = text?.substring(0, 1)?.toUpperCase(Locale.getDefault()) + text?.substring(1)

        }else {
            txtLabel.text = activity.getString(R.string.unknown_labeling)
        }
        txtPlatform.text =  browseItem.computed_browser?.Platform

        val textBrowser = browseItem.computed_browser?.Browser
        val textVersion = browseItem.computed_browser?.Version
        txtBrowserVersion.text = "$textBrowser - $textVersion"

        val textCity =  browseItem.geo?.city ?: activity.getString(R.string.unknown_city)
        val textCountry = browseItem.computed_location
        txtGeoLocation.text = "$textCity - $textCountry"

        itemView.setOnClickListener {

        }
    }
}