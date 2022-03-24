package com.example.factoryapp

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.row.view.*

class MyAdapter(val arrayList: ArrayList<Model>, val context: Context) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val title_Tv = itemView.findViewById<TextView>(R.id.Title_Tv)
        val description_Tv = itemView.findViewById<TextView>(R.id.description_Tv)
        val image_Iv = itemView.findViewById<ImageView>(R.id.image_Iv)
        fun bindItems(model: Model) {

//            itemView.Title_Tv.text = model.title
//            itemView.description_Tv.text = model.des
            itemView.image_Iv.setImageResource(model.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.row, parent, false)

        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(arrayList[position])
        holder.title_Tv.text = arrayList[position].title
        holder.description_Tv.text = arrayList[position].des


        holder.image_Iv.setOnLongClickListener {
            Snackbar.make(it, "刪除chart", Snackbar.LENGTH_LONG)
                .setAction("確認") {
                    arrayList.removeAt(position)
                    notifyDataSetChanged()
                }.show()

            true
        }
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }
}