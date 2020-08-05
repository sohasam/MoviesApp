package com.example.moviesapp.data.retrofit

import com.example.moviesapp.data.pojos.MoviesModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
@GET("3/search/movie")
fun search(@Query("api_key") api_key: String,
           @Query("query") query: String
) : Call<MoviesModel>
}