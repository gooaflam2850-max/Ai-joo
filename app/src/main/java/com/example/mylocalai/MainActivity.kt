package com.example.mylocalai

import android.os.Bundle
import android.webkit.JavascriptInterface
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        webView = WebView(this)

        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true
        webView.webViewClient = WebViewClient()

        webView.addJavascriptInterface(AndroidAI(), "AndroidAI")

        webView.loadUrl("file:///android_asset/index.html")

        setContentView(webView)
    }

    inner class AndroidAI {

        @JavascriptInterface
        fun generate(prompt: String): String {
            return "المحرك المحلي لم يتم ربطه بعد."
        }
    }
}
