package com.example.webview

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import com.example.webview.databinding.ActivityMainBinding
import com.example.webview.databinding.ActivityWebViewBinding

class WebViewActivity : AppCompatActivity() {

    private lateinit var binding : ActivityWebViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebViewBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    // 뒤로가기 버튼 설정
    override fun onBackPressed() {
        if(binding.wvWebview.canGoBack()) {
            binding.wvWebview.goBack()
        } else {
            super.onBackPressed()
        }
    }

    // 웹뷰 화면 구성
    @RequiresApi(Build.VERSION_CODES.O)
    private fun webViewSetup() {
        //refer to the webview client -> not exit to external web view
        binding.wvWebview.webViewClient = WebViewClient()

        binding.wvWebview.apply {
            loadUrl("https://www.google.com/")
            settings.javaScriptEnabled = true
            settings.safeBrowsingEnabled = true

        }
    }
}