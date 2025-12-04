package com.example.aed

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        
        setContentView(R.layout.activity_main)
        
        val btnStart = findViewById<Button>(R.id.btn_start)
        btnStart.setOnClickListener {
            val intent = Intent(this, AedListActivity::class.java)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        //跳轉到AEDCPR教學
        val btnTeach = findViewById<Button>(R.id.btn_teach)
        btnTeach.setOnClickListener {
            val intent = Intent(this, AEDteach::class.java)
            startActivity(intent)
        }

    }
}