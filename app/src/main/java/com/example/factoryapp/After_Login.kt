package com.example.factoryapp

import android.annotation.SuppressLint
import android.content.ClipData
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_after_login.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class After_Login : AppCompatActivity() {
    @SuppressLint("NotifyDataSetChanged")

    private val arrayList = ArrayList<Model>()
    private lateinit var myAdapter : MyAdapter

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
        myAdapter = MyAdapter(arrayList, this)
        recyclerView_of_AfterLogin.layoutManager = LinearLayoutManager(this)
        recyclerView_of_AfterLogin.adapter = myAdapter


        // 將itemTouchHelper attach 到 recyclerView
        val itemTouchHelper = ItemTouchHelper(simpleCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView_of_AfterLogin)


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




    val simpleCallback = object : ItemTouchHelper.SimpleCallback
        (ItemTouchHelper.UP or ItemTouchHelper.DOWN or ItemTouchHelper.START or ItemTouchHelper.END, 0) {
        // 拖移 RecyclerView 裡的 items 會用到 onMove
        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean {
            val fromPosition = viewHolder.absoluteAdapterPosition
            val toPosition = target.absoluteAdapterPosition
            Collections.swap(arrayList, fromPosition, toPosition)

            myAdapter.notifyItemMoved(fromPosition, toPosition)

            return false
        }

        // 左右滑 RecyclerView 裡的 items 會用到 onSwiped
        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            TODO("Not yet implemented")
        }

    }




    private fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}