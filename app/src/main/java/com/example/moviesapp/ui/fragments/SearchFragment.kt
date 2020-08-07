package com.example.moviesapp.ui.fragments

import android.app.Activity
import android.os.Bundle
import android.util.Log
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
import kotlinx.android.synthetic.main.fragment_search.*
import java.util.ArrayList

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SearchFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SearchFragment : Fragment() {
    var searchView : SearchView ?=null //--
    var recyclerView:RecyclerView?=null

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
    var view :View =    inflater.inflate(R.layout.fragment_search, container, false)
        searchView =    view.findViewById<SearchView>(R.id.searchView)//--
       recyclerView =   view.findViewById<RecyclerView>(R.id.recycleView)
        recyclerView!!.layoutManager = LinearLayoutManager(activity)

            return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        searchView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return  true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null) {
                    (activity as MainActivity).onSearchTextChange(newText)
//
                }
                return  true
            }
        })


    }
    fun viewListMovies(movies:List<Movie>) {
//        myMovies= movies
        Log.i("soha","______________ movies$movies")

        recyclerView!!.adapter = activity?.let { MoviesListAdapter(movies, it) };

        //   recyclerView!!.adapter?.notifyDataSetChanged()

    }





    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SearchFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SearchFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

}
