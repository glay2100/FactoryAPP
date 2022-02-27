package com.example.factoryapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_after_login.*

class After_Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_after_login)


        intent?.extras?.let {
            val value = it.getString("Key")
            title = value
        }


        val arrayList = ArrayList<Model>()

        arrayList.add(Model("NewChart", "This is a Chart description", R.drawable.mpchart_pie))
        arrayList.add(Model("NewChart", "This is a Chart description", R.drawable.mpchart_pie))
        arrayList.add(Model("NewChart", "This is a Chart description", R.drawable.mpchart_pie))
        arrayList.add(Model("NewChart", "This is a Chart description", R.drawable.mpchart_pie))
        arrayList.add(Model("NewChart", "This is a Chart description", R.drawable.mpchart_pie))
        arrayList.add(Model("NewChart", "This is a Chart description", R.drawable.mpchart_pie))
        arrayList.add(Model("NewChart", "This is a Chart description", R.drawable.mpchart_pie))
        arrayList.add(Model("NewChart", "This is a Chart description", R.drawable.mpchart_pie))

        val myAdapter = MyAdapter(arrayList, this)

        recyclerView_of_AfterLogin.layoutManager = LinearLayoutManager(this)
        recyclerView_of_AfterLogin.adapter = myAdapter
    }
}