package com.example.moviesapp.presenters

import android.content.Context
import android.util.Log
import com.example.moviesapp.contracts.IHomeContract
import com.example.moviesapp.data.HomeDataModel
import com.example.moviesapp.data.pojos.MoviesModel
import com.example.moviesapp.data.roomDatabase.entities.Movie

class HomeMoviesPresenter(var view:IHomeContract.IHomeView,var context:Context):IHomeContract.IHomePresenter {
    var dataModel : IHomeContract.IHomeModel=  HomeDataModel (this,context);
    override fun getMoviesWithTitle(title: String) {
        dataModel.getMoviesWithTitleFromApi(title);
    }

    override fun onSuccessRetrieveMovies(movies: MoviesModel) {
              view.renderMovies(movies.results);

    }

    override fun onFailedToRetrieveMovies() {
        Log.i("soha","faillllll");
        view.renderMovies(null)
    }

    override fun addMovieToFavourites(movie: Movie) {
        Log.i("soha", "presenter add :${movie}");
        dataModel.addMovieToFavouriteTable(movie)
    }

    override fun getFavouriteMovies(): List<Movie> {
       return  dataModel.retrieveFavouriteMovies()
    }
}