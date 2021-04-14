package com.example.theatrum

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.theatrum.util.SharedPrefereces

class SplashActivity : AppCompatActivity() {
    lateinit var pre: SharedPrefereces
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        pre = SharedPrefereces(this)

        Handler().postDelayed({
            var i = Intent()

            if (pre.firstInstall == false) {
                i = Intent(this, WalkthroughActivity::class.java)
            } else {
                i = Intent(this, MainActivity::class.java)
            }

            startActivity(i)
            finish()

        },3000)
    }
}