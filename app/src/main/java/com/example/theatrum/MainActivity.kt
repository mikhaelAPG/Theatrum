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

        FirebaseAuth.getInstance().addAuthStateListener { firebaseAuth ->
            // called once this listener is attached and every time after the auth state changes

            firebaseAuth.currentUser?.let {
                // the user is logged in
                startActivity(Intent(this, ProfileActivity::class.java))

            } ?: run {
                // the user is logged out, log him/her in
                signIn()
            }
        }
    }

    private fun signIn() {
        // we are using Google, Email-Password, and Phone Number based authentication
        val providers = listOf(
                AuthUI.IdpConfig.GoogleBuilder().build(),
                AuthUI.IdpConfig.EmailBuilder().build(),
        )

        val authIntent = AuthUI.getInstance().createSignInIntentBuilder()
                // set a custom logo to be shown on the login screen
                .setLogo(R.mipmap.ic_theatrum)
                // set the login screen's theme
                .setTheme(R.style.Theme_AppCompat_DayNight_NoActionBar)
                // define the providers that will be used
                .setAvailableProviders(providers)
                // disable smart lock that automatically logs in a previously logged in user
                .setIsSmartLockEnabled(false)
                // set the terms of service and private policy URL for your app
                .setTosAndPrivacyPolicyUrls("example.termsofservice.com", "example.privatepolicy.com")
                .build()

        startActivity(authIntent)

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