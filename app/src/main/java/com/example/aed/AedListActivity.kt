package com.example.aed

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AedListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aed_list)

        val btnBack = findViewById<Button>(R.id.btn_back)
        btnBack.setOnClickListener { finish() }

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // ★ 你 17 個 AED 的完整列表 ★

        val aedList = listOf(
            AedLocation("維澈樓AED", "維澈樓 1 樓", 24.956828189067945, 121.24085895583634),

            AedLocation("教學大樓AED", "教學大樓 1 樓", 0.0, 0.0),
            AedLocation("良善宿舍AED", "良善宿舍 1 樓", 0.0, 0.0),
            AedLocation("篤信大樓AED", "篤信大樓 1 樓", 0.0, 0.0),
            AedLocation("中正樓AED", "服務學習中心入口", 0.0, 0.0),
            AedLocation("設計望樓AED", "設計望樓 1 樓", 0.0, 0.0),
            AedLocation("工學館AED", "工學館 1 樓", 0.0, 0.0),
            AedLocation("商學管理大樓AED", "商學大樓 1 樓", 0.0, 0.0),
            AedLocation("科學館AED", "科學館 1 樓", 0.0, 0.0),

            AedLocation("圖書館AED", "圖書館 2 樓", 0.0, 0.0),
            AedLocation("活動中心AED", "培英廳入口", 0.0, 0.0),
            AedLocation("全人教育村AED", "衛生保健組入口", 0.0, 0.0),
            AedLocation("力行宿舍AED", "力行宿舍 1 樓", 0.0, 0.0),
            AedLocation("體育館AED", "體育館 1 樓", 0.0, 0.0),
            AedLocation("薄膜中心AED", "薄膜中心 2 樓", 0.0, 0.0),
            AedLocation("信實宿舍AED", "信實宿舍 1 樓", 0.0, 0.0),
            AedLocation("熱誠宿舍AED", "熱誠宿舍 2 樓", 0.0, 0.0)
        )
        recyclerView.adapter = AedAdapter(aedList) { aed ->

            val intent = Intent(this, AedDetailActivity::class.java)
            intent.putExtra("name", aed.name)
            intent.putExtra("detail", aed.detail)
            intent.putExtra("lat", aed.lat)
            intent.putExtra("lng", aed.lng)
            startActivity(intent)
        }
    }
}
