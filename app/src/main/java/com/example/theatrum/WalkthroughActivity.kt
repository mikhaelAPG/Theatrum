package com.example.theatrum

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import com.example.theatrum.adapter.WalkthroughAdapter
import kotlinx.android.synthetic.main.activity_walkthrough.*

class WalkthroughActivity : AppCompatActivity() {

    lateinit var wkAdapter: WalkthroughAdapter
    val dots = arrayOfNulls<TextView>(3)
    var currentPage: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_walkthrough)

        wkAdapter = WalkthroughAdapter(this)
        vp_walkthrough.adapter = wkAdapter
        dotsIndicator(currentPage)

        initAction()
    }

    fun initAction () {
        vp_walkthrough.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                dotsIndicator(position)
                currentPage = position
            }

            override fun onPageScrollStateChanged(state: Int) {

            }

        })

        tv_lanjutkan.setOnClickListener {

            if(vp_walkthrough.currentItem + 1 < dots.size) {
                vp_walkthrough.setCurrentItem(currentPage + 1)
            } else {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

        tv_lewati.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun dotsIndicator(p: Int) {
        ll_dots.removeAllViews()

        for (i in 0..dots.size-1) {
            dots[i] = TextView(this)
            dots[i]?.textSize = 35f
            dots[i]?.setTextColor(resources.getColor(R.color.grey))
            dots[i]?.text = Html.fromHtml("&#8226;")

            ll_dots.addView(dots[i])
        }

        if (dots.size > 0) {
            dots[p]?.setTextColor(resources.getColor(R.color.colorPrimary))
        }
    }
}