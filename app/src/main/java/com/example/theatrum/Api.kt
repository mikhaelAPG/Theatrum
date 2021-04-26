package com.example.theatrum

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {

    @GET("movie/popular")
    fun getPopularMovies(
        @Query("api_key") apiKey: String = "5dedc3f2c2762c1009b0952b7675afd4",
        @Query("page") page: Int
    ): Call<GetMoviesResponse>

    @GET("movie/top_rated")
    fun getTopRatedMovies(
        @Query("api_key") apiKey: String = "5dedc3f2c2762c1009b0952b7675afd4",
        @Query("page") page: Int
    ): Call<GetMoviesResponse>

    @GET("movie/upcoming")
    fun getUpcomingMovies(
        @Query("api_key") apiKey: String = "5dedc3f2c2762c1009b0952b7675afd4",
        @Query("page") page: Int
    ): Call<GetMoviesResponse>

    @GET("movie/{id}/videos")
    fun getTrailer(
        @Path("id") id: Int,
        @Query("api_key") apiKey: String = "5dedc3f2c2762c1009b0952b7675afd4"
    ): Call<GetTrailerResponse>
}