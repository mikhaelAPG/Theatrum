package com.example.theatrum

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class showTrailer : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_trailer)
        val web_view = findViewById<WebView>(R.id.show_trailer)
        val key = intent.getStringExtra("key")
        web_view.loadUrl("https://www.youtube.com/watch?v=$key")
    }
}