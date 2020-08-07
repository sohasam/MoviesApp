package com.example.moviesapp.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.moviesapp.R
import com.example.moviesapp.data.roomDatabase.entities.Movie
import com.example.moviesapp.ui.activities.MainActivity
import com.example.moviesapp.ui.adapters.MoviesListAdapter


class FavouriteFragment : Fragment() {

    var recyclerView: RecyclerView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_favourite, container, false)
        recyclerView =   view.findViewById<RecyclerView>(R.id.favouriteRecycleView)
        recyclerView!!.layoutManager = LinearLayoutManager(activity)

        return  view
    }

    //    override fun onStart() {
//        super.onStart()
//        Log.i("soha","on favourite started")
//        (activity as MainActivity).onFavouriteFragmentStarted()
//    }
//    override fun onResume() {
//        super.onResume()
//        Log.i("soha","on favourite resumed")
//        (activity as MainActivity).onFavouriteFragmentStarted()
//    }

    fun showListView(movies :List<Movie>)
    {
        recyclerView!!.adapter = activity?.let { MoviesListAdapter(movies, it) };

    }


}
