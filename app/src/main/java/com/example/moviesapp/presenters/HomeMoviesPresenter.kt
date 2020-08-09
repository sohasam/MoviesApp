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


        if (isMovieInFvourites(movie))
        {
            view.showToast("This Movie Is Already In Favourites ")
        }
        else {
            dataModel.addMovieToFavouriteTable(movie)

        }
    }

    override fun onSuccessAddMovie() {
        view.showToast("Movie Successfully Added To Favourites ")
    }

    override fun onFailedToAddMovie() {
        view.showToast("Un Expected Error")    }

    override fun removeMovieFromFavourites(movie: Movie) {
dataModel.removeMovieFromFavouritesTable(movie)
    }

    override fun getFavouriteMovies() {
        view.renderMovies(         dataModel.retrieveFavouriteMovies() )



    }

    override fun isMovieInFvourites(movie: Movie): Boolean {
return !(dataModel.selectMovieById(movie.id)==null)
    }
}