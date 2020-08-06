package com.example.moviesapp.data.roomDatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.moviesapp.data.roomDatabase.dao.MovieDao
import com.example.moviesapp.data.roomDatabase.entities.Movie


@Database(entities = [Movie::class], version = 1)
 abstract class  AppDatabase  : RoomDatabase() {
    abstract fun MovieDao(): MovieDao?


    companion object{
        private var INSTANCE: AppDatabase? = null
        open fun getInstance(context: Context?): AppDatabase? {
            if (INSTANCE == null) {
                INSTANCE =
                    Room.databaseBuilder(context!!, AppDatabase::class.java, "Movies")
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
            }
            return INSTANCE
        }

    }

}