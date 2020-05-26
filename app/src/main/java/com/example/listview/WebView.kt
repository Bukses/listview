package com.example.listview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.list_webview.*


class WebView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_webview)
        val url = intent.getStringExtra("url") ?: "https://google.com.ng"

        webView.settings.allowFileAccess = false
        webView.settings.setSupportZoom(true)
    }
}