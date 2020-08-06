package com.example.moviesapp.presenters

import android.util.Log
import com.example.moviesapp.contracts.IHomeContract
import com.example.moviesapp.data.HomeDataModel
import com.example.moviesapp.data.pojos.MoviesModel

class HomeMoviesPresenter(var view:IHomeContract.IHomeView):IHomeContract.IHomePresenter {
    var dataModel : IHomeContract.IHomeModel=  HomeDataModel (this);
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
}