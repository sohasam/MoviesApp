package com.example.moviesapp.data

import android.content.Context
import android.util.Log
import com.example.moviesapp.contracts.IHomeContract
import com.example.moviesapp.data.pojos.MoviesModel
import com.example.moviesapp.data.retrofit.ApiClient
import com.example.moviesapp.data.roomDatabase.AppDatabase
import com.example.moviesapp.data.roomDatabase.entities.Movie
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

class HomeDataModel(var presenter :IHomeContract.IHomePresenter,var context:Context) :IHomeContract.IHomeModel{

    var appDatabase: AppDatabase? = null
    init {
        appDatabase =AppDatabase.getInstance(context)
    }
    override fun getMoviesWithTitleFromApi(title: String) {
        ApiClient.client?.search("cf52c65b5b064bd7282d2382cfe9768d",title)?.enqueue(object :
            Callback<MoviesModel> {
            override fun onFailure(call: retrofit2.Call<MoviesModel>, t: Throwable) {
                presenter.onFailedToRetrieveMovies()


            }

            override fun onResponse(call: retrofit2.Call<MoviesModel>, response: Response<MoviesModel>) {
//                Log.i("soha","onResponse");
//                Log.i("soha", "onResponse${response.body()?.results}");
                if(response.body() !=null) {
                    presenter.onSuccessRetrieveMovies(response.body()!!)
                }
                else
                {
                    presenter.onFailedToRetrieveMovies()
                }

            }

        }

        )
    }

    override fun addMovieToFavouriteTable(movie: Movie) {
        Log.i("soha", "add :${movie}");

    appDatabase!!.MovieDao()!!.insertFavouriteMovie(movie)

    }

    override fun retrieveFavouriteMovies(): List<Movie> {
     var movies = appDatabase!!.MovieDao()!!.getAllFavouriteMovies()
        if (movies!=null)
            return movies  as List<Movie>
        else
        return ArrayList<Movie>()

    }
}