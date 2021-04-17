package com.example.theatrum

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        Handler().postDelayed({
            var i = Intent()
            i = Intent(this, LoginActivity::class.java)

            startActivity(i)
            finish()

        },3000)
    }
}