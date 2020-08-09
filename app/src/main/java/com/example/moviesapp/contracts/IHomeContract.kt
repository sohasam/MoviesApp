package com.example.moviesapp.contracts

import com.example.moviesapp.data.pojos.MoviesModel
import com.example.moviesapp.data.roomDatabase.entities.Movie

interface IHomeContract {

    interface IHomeView{
         fun renderMovies(movies: List<Movie>?)
        fun showToast(msg :String)

    }

    interface IHomePresenter{
        fun getMoviesWithTitle(title:String)
        fun onSuccessRetrieveMovies(movies:MoviesModel)
        fun onFailedToRetrieveMovies()
        fun addMovieToFavourites(movie:Movie)
        fun onSuccessAddMovie()
        fun onFailedToAddMovie()
        fun removeMovieFromFavourites(movie:Movie);
        fun getFavouriteMovies()
        fun isMovieInFvourites(movie: Movie):Boolean
      //  fun shareMovie(movie: Movie)


    }
    interface IHomeModel{
        fun  getMoviesWithTitleFromApi(title:String)
        fun addMovieToFavouriteTable(movie:Movie)
        fun removeMovieFromFavouritesTable(movie:Movie);
        fun selectMovieById(id: Long) :Movie?
        fun retrieveFavouriteMovies():List<Movie>


    }
}