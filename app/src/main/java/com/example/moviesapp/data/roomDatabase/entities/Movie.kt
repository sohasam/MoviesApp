package com.example.moviesapp.data.roomDatabase.entities

import android.graphics.Bitmap
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Movie (
    @PrimaryKey
    val id: Long,
    @ColumnInfo(name = "vote_average")
    val vote_average: Double?,
    @ColumnInfo(name = "poster_path")

    val poster_path: String?,
    @ColumnInfo(name = "title")

    val title: String,

    @ColumnInfo(name = "overview")

    val overview: String?,
    @ColumnInfo(name = "release_date")

    val release_date: String?,



val img:String?
)
