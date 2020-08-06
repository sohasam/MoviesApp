package com.example.moviesapp.ui.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.R
import com.example.moviesapp.data.pojos.Movie
import kotlinx.android.synthetic.main.list_item.view.*

class MoviesListAdapter (var movies:List<Movie>): RecyclerView.Adapter<MoviesListAdapter.myViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesListAdapter.myViewHolder {



        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return myViewHolder(view)
    }

    override fun getItemCount(): Int {
        Log.i("soha","______________ movies.size :${ movies.size}")

        return  movies.size
    }

    override fun onBindViewHolder(holder: MoviesListAdapter.myViewHolder, position: Int) {
        holder.itemView.titleTextView.text =movies[position].title
        Log.i("soha","______________ title :$movies")

        if (movies[position].releaseDate== null) {

            holder.itemView.dateTextView.text = movies[position].releaseDate;
        }

        if (movies[position].voteAverage== null) {
            holder.itemView.rateTextView.text = movies[position].voteAverage.toString()
        }



    }

    class myViewHolder(v: View): RecyclerView.ViewHolder(v) {

    }
}
