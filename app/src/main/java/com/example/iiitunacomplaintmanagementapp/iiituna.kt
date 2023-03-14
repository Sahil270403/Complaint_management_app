package com.example.iiitunacomplaintmanagementapp

import android.os.Bundle
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity

class iiituna : AppCompatActivity() {

    private lateinit var webView: WebView
    private var URL = "https://iiitu.ac.in/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_iiituna)

        webView = findViewById(R.id.webview)

        webView.apply {
            loadUrl(URL)
        }
    }
}