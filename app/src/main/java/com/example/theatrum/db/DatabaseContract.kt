package com.example.theatrum.db

import android.provider.BaseColumns

class DatabaseContract {
    class MovieColumn: BaseColumns{
        companion object {
            const val TABLE_NAME = "movie_local"
            const val _ID = "_id"
            const val TITLE = "title"
            const val OVERVIEW = "overview"
            const val POSTER_PATCH = "poster_patch"
            const val BACKDROP_PATCH = "backdrop_patch"
            const val VOTE_AVERAGE = "vote_average"
            const val RELEASE_DATE = "release_date"
        }
    }
}