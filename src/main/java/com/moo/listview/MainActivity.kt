package com.moo.listview

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var array = arrayOf("Melbourne", "Vienna", "Vancouver", "Toronto", "Calgary",
            "Adelaide", "Perth", "Auckland", "Helsinki", "Hamburg", "Munich", "New York",
            "Sydney", "Paris", "Cape Town", "Barcelona", "London", "Bangkok")
            //create assets folder
            //


            setContentView(R.layout.activity_main)
            //create an array adapter to bring list_item and
            //your array items together
            val adapter = ArrayAdapter(this, R.layout.listview_item, array)
            //find listview and set adapter(17) to it
            val listView = findViewById(R.id.listview_1) as ListView
            listView.adapter = adapter

        listView.onItemClickListener = object : AdapterView.OnItemClickListener{
            override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                val itemValue = listView.getItemAtPosition(p2) as String
                Toast.makeText(applicationContext, "You Pick $itemValue",
                Toast.LENGTH_LONG).show()
                //create a new page/activity
                //right click on app, new page/activity
                //we link to the new page/activity
                //intents
                //Yypes
                //1. Explicit - link
                val intent = Intent(applicationContext, city::class.java)
                intent.putExtra("position", p2)
                startActivity(intent)


            }
        }
    }
}