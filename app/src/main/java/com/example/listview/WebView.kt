package com.example.listview

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.list_webview.*

@SuppressLint("Registered")
class WebView:AppCompatActivity (){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.list_webview)
        webView.loadUrl("https://thevoicenews.com.ng/")
    }
}