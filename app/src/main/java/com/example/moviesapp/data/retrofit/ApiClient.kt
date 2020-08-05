package com.example.moviesapp.data.retrofit

import android.util.Log
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    var url :String = "https://api.themoviedb.org/"
    var client: ApiService? = null
        get() {

            val gson = GsonBuilder()
                .setLenient()
                .create()

            val retrofitBuilder = Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()

            return  retrofitBuilder.create<ApiService>(ApiService::class.java)
        }

}