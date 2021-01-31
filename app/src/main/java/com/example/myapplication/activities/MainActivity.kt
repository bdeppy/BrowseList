package com.example.myapplication.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.exam.project.Exam.adapter.BrowseAdapter
import com.example.myapplication.R
import com.example.myapplication.model.BrowserItemsModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_main.*
import java.io.IOException

class MainActivity : AppCompatActivity() {

    var browserItemsModel: BrowserItemsModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {

            val intent = Intent(this, FilterActivity::class.java)
            intent.putExtra("items", browserItemsModel)
            startActivity(intent)
        }

        readJsonFile()

        initViews()

    }

    private fun initViews() {

        recyclerView.layoutManager = LinearLayoutManager(this)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun readJsonFile() {

        val gson = Gson()

        val jsonFileString = applicationContext.let { getJsonDataFromAsset(it, "apidemo.json") }

        val browserHistory = object : TypeToken<BrowserItemsModel>() {}.type

        browserItemsModel = gson.fromJson(jsonFileString, browserHistory)

        recyclerView.adapter = browserItemsModel?.items?.let { BrowseAdapter(it,this@MainActivity) }

        val groupBy = browserItemsModel?.items?.groupBy { it.computed_location == "France" }

        val france = groupBy?.get(true)

        println(groupBy)
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