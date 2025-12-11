package com.example.aed

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Locale

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)  // ⭐ 只設置一次

        // 系統邊距設置
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // ⭐ 第二步：設置所有按鈕監聽器
        setupButtons()
    }

    // 設置所有按鈕
    private fun setupButtons() {
        // 開始按鈕 - 跳轉到 AED 列表
        val btnStart = findViewById<Button>(R.id.btn_start)
        btnStart.setOnClickListener {
            val intent = Intent(this, AedListActivity::class.java)
            startActivity(intent)
        }

        // QA 按鈕 - 跳轉到常見問題
        val btnQA = findViewById<Button>(R.id.btn_QA)
        btnQA.setOnClickListener {
            val intent = Intent(this, AEDFaq::class.java)
            startActivity(intent)
        }

        // 教學按鈕 - 跳轉到 AED/CPR 教學
        val btnTeach = findViewById<Button>(R.id.btn_teach)
        btnTeach.setOnClickListener {
            val intent = Intent(this, AEDteach::class.java)
            startActivity(intent)
        }
    }
}