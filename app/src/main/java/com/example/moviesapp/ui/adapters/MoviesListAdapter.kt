package com.example.moviesapp.ui.adapters

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
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

        if (movies[position].release_date!= null) {

            holder.itemView.dateTextView.text = movies[position].release_date;
        }

        if (movies[position].vote_average!= null) {
            holder.itemView.rateTextView.text = movies[position].vote_average.toString()
        }

        holder.itemView.btn_favourit.setOnClickListener {
            (context as MainActivity).onFavouriteBtnClicke( movies[position])
        }
        var url=""
        if (movies[position].poster_path!= null)
        {
         url = "https://image.tmdb.org/t/p/w500${movies[position].poster_path}"
        }
        else
        {// dafault url if there is no img
            url ="https://sd.keepcalms.com/i-w600/keep-calm-poster-not-found.jpg"
        }

        Glide.with(context).load(url).into(
            holder.itemView.imageView
        )

        holder.itemView.share_btn.setOnClickListener(View.OnClickListener {
            (context as MainActivity).onShareBtnClicked(movies[position])
        })




        // Change Button Style
        // star -----> Search Fragment
        //Recycle Bin ---> Favourite Fragment
        if(!(context as MainActivity).isSearchOrFavouriteFragment()) {

                        holder.itemView.btn_favourit.setBackgroundResource(R.drawable.rycle)
        }



    }

    class myViewHolder(v: View): RecyclerView.ViewHolder(v) {

    }
}
