package com.example.theatrum

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.*
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        FirebaseAuth.getInstance().currentUser?.let { firebaseUser ->
            // if the user is logged in, display their info on the screen
            etName.setText(firebaseUser.displayName)
        }

        btnUpdateName.setOnClickListener {
            // update the name here
            val nameUpdate = UserProfileChangeRequest.Builder()
                .setDisplayName(etName.text.toString())
                .build()

            FirebaseAuth.getInstance().currentUser?.updateProfile(nameUpdate)
        }

        btnUpdatePwd.setOnClickListener {
            // update the password here
            FirebaseAuth.getInstance().currentUser?.updatePassword(etPassword.text.toString())
        }

        btnSignOut.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
        }

    }

}