package com.exam.project.Exam.adapter

import android.app.Activity
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.model.Item


class BrowseAdapter(browseList:ArrayList<Item>, activity: Activity): RecyclerView.Adapter<BrowseViewHolder>() {

    var browseList = browseList

    var activity = activity

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BrowseViewHolder {
        return BrowseViewHolder(parent)
    }

    override fun onBindViewHolder(holder: BrowseViewHolder, position: Int) {
        holder.bindTo(browseList[position],activity)
    }

    override fun getItemCount(): Int {
       return browseList.size
    }

    public fun setList(browseList: ArrayList<Item>){
        this.browseList = browseList
        notifyDataSetChanged()
    }
}