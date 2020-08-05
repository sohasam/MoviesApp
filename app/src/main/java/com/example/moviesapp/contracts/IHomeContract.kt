package com.example.moviesapp.contracts

import com.example.moviesapp.data.pojos.MoviesModel

interface IHomeContract {

    interface IHomeView{
         fun renderMovies(movies:List<MoviesModel>);
    }

    interface IHomePresenter{
        fun getMoviesWithTitle(title:String)
        fun onSuccessRetrieveMovies(movies:MoviesModel);
        fun onFailedToRetrieveMovies();


    }
    interface IHomeModel{
        fun  getMoviesWithTitleFromApi(title:String)

    }
}