package com.example.aed

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class AedDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aed_detail)

        val tvTitle = findViewById<TextView>(R.id.tvTitle)
        val tvDetail = findViewById<TextView>(R.id.tvDetail)
        val btnBack = findViewById<Button>(R.id.btn_back_detail)
        val btnOpenMap = findViewById<Button>(R.id.btn_open_map)

        // ⭐ 1. 接收傳來的資料
        val name = intent.getStringExtra("name")
        val detail = intent.getStringExtra("detail")
        val lat = intent.getDoubleExtra("lat", 0.0)
        val lng = intent.getDoubleExtra("lng", 0.0)

        // ⭐ 2. 顯示文字
        tvTitle.text = name
        tvDetail.text = detail

        // ⭐ 3. 返回按鈕
        btnBack.setOnClickListener {
            finish()
        }

        // ⭐ 4. Google Map 導航
        btnOpenMap.setOnClickListener {
            val uri = "geo:$lat,$lng?q=$lat,$lng($name)"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
            intent.setPackage("com.google.android.apps.maps")
            startActivity(intent)
        }
    }
}
