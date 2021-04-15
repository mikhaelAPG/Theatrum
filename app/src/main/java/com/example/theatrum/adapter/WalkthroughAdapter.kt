package com.example.theatrum.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.PagerAdapter
import com.example.theatrum.R

class WalkthroughAdapter(val context: Context): PagerAdapter() {

    val imgArray: IntArray = intArrayOf(R.drawable.movimaker, R.drawable.popcorn, R.drawable.drink)
    val titleArray: Array<String> = arrayOf("Movie Maker", "Popcorn", "Drink")
    val descArray: Array<String> = arrayOf("Jangan lewatkan video terakhir dan selalu up-to-date", "Siapkan makanan kecil ketika menonton", "Siapkan minuman ketika menonton")
    override fun getCount(): Int {
        return imgArray.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view: View = LayoutInflater.from(context).inflate(R.layout.slide_walkthrough, container, false)

        val txtTitle: TextView = view.findViewById(R.id.tv_title)
        val txtDescription: TextView = view.findViewById(R.id.tv_description)
        val img: ImageView = view.findViewById(R.id.tv_img)

        txtTitle.text = titleArray[position]
        txtDescription.text = descArray[position]
        img.setImageDrawable(ContextCompat.getDrawable(context, imgArray[position]))
        container.addView(view)

        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val view: View = `object` as View
        container.removeView(view)
    }
}