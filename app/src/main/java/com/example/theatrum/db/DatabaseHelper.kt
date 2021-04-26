package com.example.theatrum.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.theatrum.db.DatabaseContract.MovieColumn.Companion.BACKDROP_PATCH
import com.example.theatrum.db.DatabaseContract.MovieColumn.Companion.OVERVIEW
import com.example.theatrum.db.DatabaseContract.MovieColumn.Companion.POSTER_PATCH
import com.example.theatrum.db.DatabaseContract.MovieColumn.Companion.RELEASE_DATE
import com.example.theatrum.db.DatabaseContract.MovieColumn.Companion.TABLE_NAME
import com.example.theatrum.db.DatabaseContract.MovieColumn.Companion.TITLE
import com.example.theatrum.db.DatabaseContract.MovieColumn.Companion.VOTE_AVERAGE
import com.example.theatrum.db.DatabaseContract.MovieColumn.Companion._ID

class DatabaseHelper(context: Context): SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object{
        private const val DATABASE_NAME = "db_local"
        private const val DATABASE_VERSION = 1
        private const val SQL_CREATE = "CREATE TABLE $TABLE_NAME($_ID text primary key, $TITLE text, $OVERVIEW text, $POSTER_PATCH text, $BACKDROP_PATCH text, $VOTE_AVERAGE text, $RELEASE_DATE text)"

    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(SQL_CREATE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }
}