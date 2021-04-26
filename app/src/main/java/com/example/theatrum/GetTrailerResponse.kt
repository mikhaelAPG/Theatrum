package com.example.theatrum

import com.google.gson.annotations.SerializedName

data class GetTrailerResponse (
    @SerializedName("id") val id: Int,
    @SerializedName("results") val result: ArrayList<Trailer>
)