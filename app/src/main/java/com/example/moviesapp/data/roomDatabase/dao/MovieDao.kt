package com.example.moviesapp.data.roomDatabase.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.moviesapp.data.roomDatabase.entities.Movie
@Dao

interface MovieDao {
    @Query("SELECT * FROM Movie")
    fun getAllFavouriteMovies(): List<Movie?>?

    @Insert
    fun insertFavouriteMovie(movie: Movie)

    @Delete
    fun deleteFavouriteMovie(movie: Movie?)


    @Query("SELECT * FROM Movie WHERE id  LIKE :movieId ")
    fun getMovieById(movieId: Int): Movie?
}