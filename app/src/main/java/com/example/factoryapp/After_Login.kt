package com.example.factoryapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_after_login.*
import kotlinx.android.synthetic.main.activity_main.*

class After_Login : AppCompatActivity() {
    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_after_login)


        // 啟動activity後讀取登入activity(MainActivity)的帳號密碼資料
        intent?.extras?.let {

            val accountOfBundle = it.getString("Account")
            val passwordOfBundle = it.getString("Password")

            // 將action bar title改成account
            title = accountOfBundle
        }


        // 建立RecyclerView的ArrayList
        val arrayList = ArrayList<Model>()
        val myAdapter = MyAdapter(arrayList, this)
        recyclerView_of_AfterLogin.layoutManager = LinearLayoutManager(this)
        recyclerView_of_AfterLogin.adapter = myAdapter


        // 建立在Toast選單中出現的項目的arraylist
        val chart_ArrayItem = arrayOf("Chart 1", "Chart 2", "Chart 3", "Chart 4")


        // fabBtn為右下角"+"的button
        val fabBtn = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        // 當fab被點擊時
        fabBtn.setOnClickListener {

            var position = 0

            // 產生選單來選擇要insert哪一個chart
            AlertDialog.Builder(this)
                .setTitle("Selecting Chart")
                .setSingleChoiceItems(chart_ArrayItem, 0) { dialogInterface, i ->
                    position = i
                }
                .setPositiveButton("Insert") { dialog, which ->
                    showToast("The Chart you insert is ${chart_ArrayItem[position]}")

                    // 將RecyclerView新增一項
                    arrayList.add(Model(chart_ArrayItem[position], "This is a Chart description", R.drawable.mpchart_pie))
                    // 更新列表
                    myAdapter.notifyDataSetChanged()
                }.show()



        }

    }

    private fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}