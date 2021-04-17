package com.example.theatrum

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.firebase.ui.auth.AuthUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottom_navigation.setOnNavigationItemSelectedListener(onBottomNavListener)

        val fr = supportFragmentManager.beginTransaction()
        fr.add(R.id.fl_fragment, HomeFragment())
        fr.commit()
    }

    private val onBottomNavListener = BottomNavigationView.OnNavigationItemSelectedListener { i ->

        var selectedFr: Fragment = HomeFragment()

        when(i.itemId) {
            R.id.item_home -> {
                selectedFr = HomeFragment()
            }

            R.id.item_ticket -> {
                selectedFr = TicketFragment()
            }

            R.id.item_profile -> {
                selectedFr = ProfileFragment()
            }
        }
        var fr = supportFragmentManager.beginTransaction()
        fr.replace(R.id.fl_fragment, selectedFr)
        fr.commit()
        true
    }
}