package com.example.theatrum.db

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.example.theatrum.db.DatabaseContract.MovieColumn.Companion.TABLE_NAME
import com.example.theatrum.db.DatabaseContract.MovieColumn.Companion._ID
import java.sql.SQLException
import kotlin.jvm.Throws

class MovieHelper(context: Context) {
    companion object{
        private const val DATABASE_TABLE = TABLE_NAME
        private lateinit var databaseHelper: DatabaseHelper
        private var INSTANCE:MovieHelper? = null
        private lateinit var database: SQLiteDatabase

        fun getIntance(context: Context):MovieHelper =
            INSTANCE?: synchronized(this){
                INSTANCE?: MovieHelper(context)
            }
    }

    init {
        databaseHelper = DatabaseHelper(context)
    }

    @Throws(SQLException::class)
    fun open(){
        database = databaseHelper.writableDatabase
    }

    fun queryAll(): Cursor {
        return database.query(DATABASE_TABLE, null, null, null, null, null, "$_ID ASC")
    }

    fun insert(values: ContentValues?): Long{
        return database.insert(DATABASE_TABLE, null, values)
    }

    fun delete(): Int{
        return database.delete(DATABASE_TABLE,"",null)
    }
}