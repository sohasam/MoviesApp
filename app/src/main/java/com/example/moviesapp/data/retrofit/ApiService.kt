package com.example.moviesapp.data.retrofit

import android.graphics.Bitmap
import com.example.moviesapp.data.pojos.MoviesModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
@GET("3/search/movie")
fun search(@Query("api_key") api_key: String,
           @Query("query") query: String,
           @Query("page") page: String

) : Call<MoviesModel>



}
//https://api.themoviedb.org/3/search/movie?api_key=cf52c65b5b064bd7282d2382cfe9768d&query=ho&page=1