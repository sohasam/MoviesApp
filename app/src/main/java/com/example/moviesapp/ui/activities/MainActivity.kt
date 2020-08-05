package com.example.moviesapp.ui.activities

import android.os.Bundle
import android.telecom.Call
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.moviesapp.R
import com.example.moviesapp.contracts.IHomeContract
import com.example.moviesapp.data.pojos.MoviesModel
import com.example.moviesapp.data.retrofit.ApiClient
import com.example.moviesapp.presenters.HomeMoviesPresenter
import com.example.moviesapp.ui.adapters.MyFragmentPagerAdapter
import com.google.android.material.tabs.TabLayout
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(),IHomeContract.IHomeView {
    var presenter:IHomeContract.IHomePresenter=HomeMoviesPresenter(this);
    var tabLayout: TabLayout? = null
    var viewPager: ViewPager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tabLayout =findViewById<TabLayout>(R.id.tabLayout)
        viewPager = findViewById<ViewPager>(R.id.viewPger)
        viewTabedPage();

    }



    fun viewTabedPage(){
        var adapter :MyFragmentPagerAdapter=
            MyFragmentPagerAdapter(this,tabLayout!!.tabCount,supportFragmentManager)
        viewPager!!.adapter=adapter
        viewPager!!.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))//

        tabLayout!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {

          viewPager!!.currentItem=tab!!.position;


            }

        })


    }


    fun onSearchTextChange(text:String)
    {
        //هنادي الpresenter
        presenter.getMoviesWithTitle(text);

    }

    override fun renderMovies(movies: List<MoviesModel>) {
        TODO("Not yet implemented")
    }


}
//https://api.themoviedb.org/3/movie/550?api_key=cf52c65b5b064bd7282d2382cfe9768d
//https://api.themoviedb.org/3/search/movie?api_key=cf52c65b5b064bd7282d2382cfe9768d&language=en-US&query=Aliens%20vs%20Predator&page=1&include_adult=false
//https://api.themoviedb.org/3/search/movie?api_key=cf52c65b5b064bd7282d2382cfe9768d&query=Aliens%20vs%20Predator
//https://api.themoviedb.org/3/search/movie?api_key=cf52c65b5b064bd7282d2382cfe9768d&query=Aliens