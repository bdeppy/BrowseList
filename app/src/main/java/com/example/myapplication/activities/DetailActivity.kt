package com.example.myapplication.activities

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.exam.project.Exam.adapter.BrowseAdapter
import com.example.myapplication.R
import com.example.myapplication.model.BrowserItemsModel
import com.example.myapplication.model.Item
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_main.*
import java.io.IOException

class DetailActivity: AppCompatActivity() {

    var browserItemsModel: BrowserItemsModel? = null
    var filteredItemList = ArrayList<Item>()

    var type = ""
    var value = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        type = intent.getStringExtra("filterType")

        value = intent.getStringExtra("filterValue")

        initViews()

    }

    private fun initViews() {

        recyclerView.layoutManager = LinearLayoutManager(this)

        readJsonFile()

    }

    private fun readJsonFile() {

        val gson = Gson()

        val jsonFileString = applicationContext.let { getJsonDataFromAsset(it, "apidemo.json") }

        val browserHistory = object : TypeToken<BrowserItemsModel>() {}.type

        browserItemsModel = gson.fromJson(jsonFileString, browserHistory)

        when (type) {
            "type" -> {
                val groupBy = browserItemsModel?.items?.groupBy { it.labels?.firstOrNull() == value }
                val filteredGroupList = groupBy?.get(true)
                recyclerView.adapter = BrowseAdapter(filteredGroupList as ArrayList<Item>,this@DetailActivity)
            }
            "country" -> {
                val groupBy = browserItemsModel?.items?.groupBy { it.computed_location == value }
                val filteredGroupList = groupBy?.get(true)
                recyclerView.adapter = BrowseAdapter(filteredGroupList as ArrayList<Item>,this@DetailActivity)
            }
            "platform" -> {

                val groupBy = browserItemsModel?.items?.groupBy { it.computed_browser?.Platform == value }
                val filteredGroupList = groupBy?.get(true)
                recyclerView.adapter = BrowseAdapter(filteredGroupList as ArrayList<Item>,this@DetailActivity)
            }
            "browser" -> {
                val groupBy = browserItemsModel?.items?.groupBy { it.computed_browser?.Browser == value }
                val filteredGroupList = groupBy?.get(true)
                recyclerView.adapter = BrowseAdapter(filteredGroupList as ArrayList<Item>,this@DetailActivity)
            }
        }

        recyclerView.adapter?.notifyDataSetChanged()


    }

    fun getJsonDataFromAsset(context: Context, fileName: String): String? {
        val jsonString: String
        try {
            jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }
}