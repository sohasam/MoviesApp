package com.example.moviesapp.ui.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.R
import com.example.moviesapp.data.roomDatabase.entities.Movie
import com.example.moviesapp.ui.activities.MainActivity
import kotlinx.android.synthetic.main.list_item.view.*

class MoviesListAdapter (var movies:List<Movie>,var context :Context): RecyclerView.Adapter<MoviesListAdapter.myViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesListAdapter.myViewHolder {



        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return myViewHolder(view)
    }

    override fun getItemCount(): Int {

        return  movies.size
    }

    override fun onBindViewHolder(holder: MoviesListAdapter.myViewHolder, position: Int) {
        holder.itemView.titleTextView.text =movies[position].title

        if (movies[position].releaseDate!= null) {

            holder.itemView.dateTextView.text = movies[position].releaseDate;
        }

        if (movies[position].voteAverage!= null) {
            holder.itemView.rateTextView.text = movies[position].voteAverage.toString()
        }

        holder.itemView.favouritBtn.setOnClickListener {
            (context as MainActivity).onFavouriteBtnClicke( movies[position])
        }

    }

    class myViewHolder(v: View): RecyclerView.ViewHolder(v) {

    }
}
