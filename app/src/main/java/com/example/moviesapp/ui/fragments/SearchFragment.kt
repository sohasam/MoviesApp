package com.example.moviesapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.moviesapp.R
import com.example.moviesapp.data.roomDatabase.entities.Movie
import com.example.moviesapp.ui.activities.MainActivity
import com.example.moviesapp.ui.adapters.MoviesListAdapter



class SearchFragment : Fragment() {
    var searchView: SearchView? = null //--
    var recyclerView: RecyclerView? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view: View = inflater.inflate(R.layout.fragment_search, container, false)
        searchView = view.findViewById<SearchView>(R.id.searchView)//--
        recyclerView = view.findViewById<RecyclerView>(R.id.recycleView)
        recyclerView!!.layoutManager = LinearLayoutManager(activity)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        searchView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null) {
                    (activity as MainActivity).onSearchTextChange(newText)

                }
                return true
            }
        })


    }

    fun viewListMovies(movies: List<Movie>) {

        recyclerView!!.adapter = activity?.let { MoviesListAdapter(movies, it) };



    }


}
