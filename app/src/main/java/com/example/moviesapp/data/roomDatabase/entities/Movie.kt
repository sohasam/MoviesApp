package com.example.moviesapp.data.roomDatabase.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Movie (
    @PrimaryKey
    val id: Long,
    @ColumnInfo(name = "voteCount")
    val voteCount: Long?,
    @ColumnInfo(name = "posterPath")

    val posterPath: String?,
    @ColumnInfo(name = "title")

    val title: String,
    @ColumnInfo(name = "voteAverage")

    val voteAverage: Double?,
    @ColumnInfo(name = "overview")

    val overview: String?,
    @ColumnInfo(name = "releaseDate")

    val releaseDate: String?
)
