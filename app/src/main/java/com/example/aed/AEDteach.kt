package com.example.aed

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AEDteach : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_aedteach)
        val btn_back_main=findViewById<Button>(R.id.btn_back_main)
        btn_back_main.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        //選單放置處
        val btn_location = findViewById<ImageView>(R.id.btn_location)

        btn_location.setOnClickListener {
            val intent = Intent(this, AedListActivity::class.java)
            startActivity(intent)
        }

        //phone 電話icon預設119
        val btnCall = findViewById<ImageView>(R.id.btn_call)
        btnCall.setOnClickListener {
            val phoneNumber = "119"  // 你想預先填的電話號碼
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:$phoneNumber")
            }
            startActivity(intent)
        }
        //setting
        val btnSetting = findViewById<ImageView>(R.id.btn_setting) // 或 Button，看你 layout
        btnSetting.setOnClickListener {
            val intent = Intent(this, RegulationActivity::class.java)
            startActivity(intent)
        }
    }
}