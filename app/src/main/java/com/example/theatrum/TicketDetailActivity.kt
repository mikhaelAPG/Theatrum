package com.example.theatrum

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_ticket_detail.*

class TicketDetailActivity : AppCompatActivity() {

    var b : Bundle? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ticket_detail)

        initView()
    }

    fun initView() {
        b = intent.extras

        tv_titles.text = b?.getString("title")
        tv_descriptions.text = b?.getString("description")
    }
}