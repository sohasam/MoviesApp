package com.example.moviesapp.contracts

import com.example.moviesapp.data.pojos.MoviesModel
import com.example.moviesapp.data.roomDatabase.entities.Movie

interface IHomeContract {

    interface IHomeView{
         fun renderMovies(movies: List<Movie>?);

    }

    interface IHomePresenter{
        fun getMoviesWithTitle(title:String)
        fun onSuccessRetrieveMovies(movies:MoviesModel);
        fun onFailedToRetrieveMovies();
        fun addMovieToFavourites(movie:Movie);
        fun getFavouriteMovies()
      //  fun shareMovie(movie: Movie)


    }
    interface IHomeModel{
        fun  getMoviesWithTitleFromApi(title:String)
        fun addMovieToFavouriteTable(movie:Movie)
        fun retrieveFavouriteMovies():List<Movie>


    }
}