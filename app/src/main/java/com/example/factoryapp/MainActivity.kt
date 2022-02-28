package com.example.factoryapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val accountED = findViewById<EditText>(R.id.ed_account)
        val passwordED = findViewById<EditText>(R.id.ed_password)

        // 經由button(login_taipei)啟動After_Login這個activity
        findViewById<Button>(R.id.btn_login_taipei).setOnClickListener {
            val intent = Intent(this, After_Login::class.java)

            val accountPasswordBundle = Bundle()
            accountPasswordBundle.putString("Account", accountED.text.toString())
            accountPasswordBundle.putString("Password", passwordED.text.toString())

            intent.putExtras(accountPasswordBundle)
            startActivity(intent)
        }
    }
}