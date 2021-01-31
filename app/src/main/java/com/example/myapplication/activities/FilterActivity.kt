package com.example.myapplication.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.model.BrowserItemsModel
import com.project.theandroidcrew.groupieexpandablelist.ChildItem
import com.project.theandroidcrew.groupieexpandablelist.ExpandableHeaderItem
import com.xwray.groupie.ExpandableGroup
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.groupiex.plusAssign
import kotlinx.android.synthetic.main.activity_filter.*

class FilterActivity : AppCompatActivity() {

    private val groupAdapter = GroupAdapter<GroupieViewHolder>()
    private lateinit var groupLayoutManager: LinearLayoutManager
    var browserItemsModel: BrowserItemsModel? = null

    private val parentList = listOf(
        ExpandableHeaderItem("Types"),
        ExpandableHeaderItem("Platforms"),
        ExpandableHeaderItem("Browsers"),
        ExpandableHeaderItem("Countries")

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter)
        groupLayoutManager = LinearLayoutManager(this)

        browserItemsModel = intent.getSerializableExtra("items") as BrowserItemsModel?
        recyclerView.apply {
            layoutManager = groupLayoutManager
            adapter = groupAdapter
        }

        initData()
    }

    fun initData() {
        val countryGroupList = browserItemsModel?.items?.groupBy { it.computed_location }

        val countryList = ArrayList<ChildItem>()

        val countrykeyList = countryGroupList?.keys?.toList()

        if (countrykeyList != null) {
            for (key in countrykeyList) {

                key?.let { countryList.add(ChildItem(it,"country")) }
            }
        }

        val platformGroupList = browserItemsModel?.items?.groupBy { it.computed_browser?.Platform }

        val platformList = ArrayList<ChildItem>()

        val platformkeyList = platformGroupList?.keys?.toList()

        if (platformkeyList != null) {
            for (key in platformkeyList) {

                key?.let { platformList.add(ChildItem(it,"platform")) }
            }
        }


        val browserGroupList = browserItemsModel?.items?.groupBy { it.computed_browser?.Browser }

        val browserList = ArrayList<ChildItem>()

        val browserkeyList = browserGroupList?.keys?.toList()

        if (browserkeyList != null) {
            for (key in browserkeyList) {

                key?.let { browserList.add(ChildItem(it,"browser")) }
            }
        }


        val labelGroupList = browserItemsModel?.items?.groupBy { it.labels?.firstOrNull() }

        val labelList = ArrayList<ChildItem>()

        val labelkeyList = labelGroupList?.keys?.toList()

        if (labelkeyList != null) {
            for (key in labelkeyList) {

                key?.let { labelList.add(ChildItem(it,"type")) }
            }
        }

        var index = 0
        groupAdapter.apply {
            for (i in parentList) {
                this += ExpandableGroup(i).apply {

                    when (index) {
                        0 -> {
                            for (j in labelList) {
                                add(j)
                            }
                            index = index + 1
                        }
                        1 -> {

                            for (j in platformList) {
                                add(j)
                            }

                            index = index + 1
                        }
                        2 -> {
                            for (j in browserList) {
                                add(j)
                            }
                            index = index + 1
                        }
                        3 -> {
                            for (j in countryList) {
                                add(j)
                            }
                            index = index + 1
                        }
                    }
                }


            }

        }
    }
}
