package com.example.aed

import android.content.Intent
import android.media.Image
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AedListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aed_list)

        val btnBack = findViewById<Button>(R.id.btn_back)
        btnBack.setOnClickListener { finish() }

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

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // ★ 你 17 個 AED 的完整列表 ★

        val aedList = listOf(
            AedLocation("維澈樓AED", "維澈樓 1 樓", 24.956828189067945, 121.24085895583634, R.drawable.aed1),

            AedLocation("教學大樓AED", "教學大樓 1 樓", 24.956352969061655, 121.24194846849849, R.drawable.aed2),
            AedLocation("活動中心AED", "培英廳入口", 24.959067273925655, 121.24066959364508, R.drawable.aed3),
            AedLocation("篤信大樓AED", "篤信大樓 1 樓", 24.955805803940155, 121.24239872243264, R.drawable.aed4),
            AedLocation("智信樓AED", "服務學習中心入口", 24.95662363049665, 121.24304086583365, R.drawable.aed5),
            AedLocation("設計望樓AED", "設計望樓 1 樓", 0.0, 0.0,0),
            AedLocation("工學館AED", "工學館 1 樓", 0.0, 0.0,0),
            AedLocation("商學管理大樓AED", "商學大樓 1 樓", 0.0, 0.0,0),
            AedLocation("科學館AED", "科學館 1 樓", 0.0, 0.0,0),

            AedLocation("圖書館AED", "圖書館 2 樓", 0.0, 0.0,0),
            AedLocation("良善宿舍AED", "良善宿舍 1 樓", 0.0, 0.0,0),
            AedLocation("全人教育村AED", "衛生保健組入口", 0.0, 0.0,0),
            AedLocation("力行宿舍AED", "力行宿舍 1 樓", 0.0, 0.0,0),
            AedLocation("體育館AED", "體育館 1 樓", 0.0, 0.0,0),
            AedLocation("薄膜中心AED", "薄膜中心 2 樓", 0.0, 0.0,0),
            AedLocation("信實宿舍AED", "信實宿舍 1 樓", 0.0, 0.0,0),
            AedLocation("熱誠宿舍AED", "熱誠宿舍 2 樓", 0.0, 0.0,0)
        )
        recyclerView.adapter = AedAdapter(aedList) { aed ->

            val intent = Intent(this, AedDetailActivity::class.java)
            intent.putExtra("name", aed.name)
            intent.putExtra("detail", aed.detail)
            intent.putExtra("lat", aed.lat)
            intent.putExtra("lng", aed.lng)
            intent.putExtra("imageResId", aed.imageResId)
            startActivity(intent)
        }
    }
}
