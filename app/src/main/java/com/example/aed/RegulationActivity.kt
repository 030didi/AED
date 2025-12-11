package com.example.aed

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class RegulationActivity : AppCompatActivity() {

    // AED 法規內容
    private val regulations = mapOf(
        R.id.regulation_1 to """
            第 1 條 - 立法目的
            
            為提升緊急救護品質，普及自動體外心臟電擊去顫器（AED）之使用，保障民眾生命安全，特制定本法。
        """.trimIndent(),

        R.id.regulation_2 to """
            第 2 條 - AED 定義
            
            自動體外心臟電擊去顫器（AED）指一種可攜帶式醫療設備，能自動偵測心律不整並施予電擊，使心臟恢復正常運作。
        """.trimIndent(),

        R.id.regulation_3 to """
            第 3 條 - 設置場所規定
            
            下列公共場所應設置 AED：
            1. 交通要衝（機場、高鐵站、大型車站）
            2. 學校（大專院校、高中職）
            3. 大型集會場所（體育場館、展覽館）
            4. 大型購物中心及觀光旅遊地區
            5. 其他經主管機關公告之場所
        """.trimIndent(),

        R.id.regulation_4 to """
            第 4 條 - 使用資格
            
            任何人於緊急情況下，為救助他人生命，得使用 AED 進行急救。
            
            完成 AED 教育訓練並取得證書者，優先擔任緊急救護協助人員。
        """.trimIndent(),

        R.id.regulation_5 to """
            第 5 條 - 管理維護責任
            
            設置 AED 之場所管理人應：
            1. 指定專人負責 AED 管理
            2. 定期檢查設備功能
            3. 確保設備放置於明顯易取得處
            4. 記錄維護保養情形
            5. 向主管機關登記 AED 設置資訊
        """.trimIndent(),

        R.id.regulation_6 to """
            第 6 條 - 善意使用保護
            
            救助人員於緊急情況下，本於善意使用 AED 對傷病患進行急救，其行為不罰。
            
            但有重大過失者，不在此限。
        """.trimIndent(),

        R.id.regulation_7 to """
            第 7 條 - 教育訓練
            
            主管機關應辦理 AED 教育訓練，課程內容包括：
            1. 心肺復甦術（CPR）
            2. AED 操作方式
            3. 緊急救護流程
            4. 法律責任說明
            
            訓練時數不得少於 4 小時。
        """.trimIndent(),

        R.id.regulation_8 to """
            第 8 條 - 罰則規定
            
            應設置 AED 之場所未依規定設置者，處新臺幣 3 萬元以上 15 萬元以下罰鍰。
            
            設置 AED 未依規定維護管理者，處新臺幣 1 萬元以上 5 萬元以下罰鍰。
            
            經通知限期改善，屆期未改善者，按次處罰。
        """.trimIndent()
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regulation)

        // 返回按鈕
        val btnBack = findViewById<Button>(R.id.btn_back_setting)
        btnBack.setOnClickListener {
            finish()
        }

        // 設置所有法規項目的點擊事件
        setupRegulationClicks()

        // 設置底部導航按鈕
        setupBottomNavigation()
    }

    private fun setupBottomNavigation() {

        val btnLocation = findViewById<ImageView>(R.id.btn_location)
        btnLocation.setOnClickListener {
            startActivity(Intent(this, AedListActivity::class.java))
        }

        val btnCall = findViewById<ImageView>(R.id.btn_call)
        btnCall.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:119"))
            startActivity(intent)
        }

        // 法規頁，不要跳回自己
        val btnLaw = findViewById<ImageView>(R.id.btn_law)
        btnLaw.setOnClickListener {
            // Do nothing or Toast
        }
    }

    private fun setupRegulationClicks() {
        regulations.forEach { (viewId, content) ->
            val textView = findViewById<TextView>(viewId)
            val title = textView.text.toString()

            textView.setOnClickListener {
                showRegulationDialog(title, content)
            }
        }
    }

    private fun showRegulationDialog(title: String, content: String) {
        AlertDialog.Builder(this)
            .setTitle(title)
            .setMessage(content)
            .setPositiveButton("確定") { dialog, _ ->
                dialog.dismiss()
            }
            .setCancelable(true)
            .show()
    }
}