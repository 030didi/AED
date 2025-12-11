package com.example.aed

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class AedDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aed_detail)

        //選單放置處
        val btn_location = findViewById<ImageView>(R.id.btn_location)
        btn_location.setOnClickListener {
            val intent = Intent(this, AedListActivity::class.java)
            startActivity(intent)
        }
        //電話icon預設119
        val btnCall = findViewById<ImageView>(R.id.btn_call)
        btnCall.setOnClickListener {
            val phoneNumber = "119"  // 你想預先填的電話號碼
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:$phoneNumber")
            }
            startActivity(intent)
        }
        //setting
        val btnSetting = findViewById<ImageView>(R.id.btn_setting)
        btnSetting.setOnClickListener {
            val intent = Intent(this, RegulationActivity::class.java)
            startActivity(intent)
        }


        val tvTitle = findViewById<TextView>(R.id.tvTitle)
        val tvDetail = findViewById<TextView>(R.id.tvDetail)
        val btnBack = findViewById<Button>(R.id.btn_back_detail)
        val btnOpenMap = findViewById<Button>(R.id.btn_open_map)
        val imageAedDetail = findViewById<ImageView>(R.id.imageAedDetail)
        val imageResId = intent.getIntExtra("imageResId",0)

        if (imageResId != 0) {
            imageAedDetail.setImageResource(imageResId)
            imageAedDetail.visibility = View.VISIBLE
        } else {
            imageAedDetail.visibility = View.GONE
        }


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
