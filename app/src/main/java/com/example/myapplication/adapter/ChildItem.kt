package com.project.theandroidcrew.groupieexpandablelist
import android.content.Intent
import com.example.myapplication.R
import com.example.myapplication.activities.DetailActivity
import com.google.android.material.snackbar.Snackbar

import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder


import kotlinx.android.synthetic.main.item_list_child.view.*

open class ChildItem( val title : String, val type: String) : Item() {

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.root.child_textTitle.text = title

        viewHolder.itemView.setOnClickListener {

            val intent = Intent(viewHolder.containerView.context, DetailActivity::class.java)
            intent.putExtra("filterValue", title)
            intent.putExtra("filterType", type)
            viewHolder.containerView.context.startActivity(intent)

        }

    }
    override fun getLayout(): Int {
        return R.layout.item_list_child
    }

}
