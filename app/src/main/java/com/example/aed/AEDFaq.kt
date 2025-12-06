package com.example.aed

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class AEDFaq : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_faq)

        //選單放置處
        val btn_location = findViewById<ImageView>(R.id.btn_location)
        //phone
        //setting
        btn_location.setOnClickListener {
            val intent = Intent(this, AedListActivity::class.java)
            startActivity(intent)
        }

        val btnBack = findViewById<Button>(R.id.btn_back_faq)
        btnBack.setOnClickListener { finish() }
    }
}
