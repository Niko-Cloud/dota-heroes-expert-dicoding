package com.dicoding.dotaheroesbase.ui.webviewdocs

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity

class WebViewDocsActivity : AppCompatActivity() {

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val myWebView = WebView(this)
        setContentView(myWebView)

        supportActionBar?.title = "Open Dota API"

        myWebView.loadUrl("https://docs.opendota.com/")
        myWebView.settings.javaScriptEnabled = true
    }
}
