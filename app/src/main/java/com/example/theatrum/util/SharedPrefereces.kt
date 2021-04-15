package com.example.theatrum.util

import android.content.Context
import android.preference.PreferenceManager

class SharedPrefereces(val context: Context) {
    companion object { // bisa akses member dari suatu kelas tanpa melalui objek
        private const val FIRST_INSTALL = "FIRST INSTALL"
    }

    private val p = PreferenceManager.getDefaultSharedPreferences(context)

    var firstInstall = p.getBoolean(FIRST_INSTALL, false)
        set(value) = p.edit().putBoolean(FIRST_INSTALL, value).apply()
}