package com.example.factoryapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 經由button(login_taipei)啟動After_Login這個activity
        findViewById<Button>(R.id.btn_login_taipei).setOnClickListener {
            val intent = Intent(this, After_Login::class.java)
            intent.putExtra("Key", "billy")
            startActivity(intent)
        }
        //
    }
}