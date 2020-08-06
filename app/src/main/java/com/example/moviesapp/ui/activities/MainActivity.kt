package com.example.moviesapp.ui.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.moviesapp.R
import com.example.moviesapp.contracts.IHomeContract
import com.example.moviesapp.data.roomDatabase.entities.Movie
import com.example.moviesapp.presenters.HomeMoviesPresenter
import com.example.moviesapp.ui.adapters.MyFragmentPagerAdapter
import com.example.moviesapp.ui.fragments.SearchFragment
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_search.*

class MainActivity : AppCompatActivity(), IHomeContract.IHomeView {
    var adapter: MyFragmentPagerAdapter? = null;
    var presenter: IHomeContract.IHomePresenter ?=null
    var tabLayout: TabLayout? = null
    var viewPager: ViewPager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i("soha", "onCreate");

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       presenter = HomeMoviesPresenter(this,this);

        tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        viewPager = findViewById<ViewPager>(R.id.viewPger)
        viewTabedPage();

    }


    override fun onStart() {
        super.onStart()
        var movies = presenter!!.getFavouriteMovies()
        Log.i("soha","Favourites = $movies")

    }

    fun viewTabedPage() {
        adapter =
            MyFragmentPagerAdapter(this, tabLayout!!.tabCount, supportFragmentManager)
        viewPager!!.adapter = adapter
        viewPager!!.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))//

        tabLayout!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {

                viewPager!!.currentItem = tab!!.position;


            }

        })


    }


    fun onSearchTextChange(text: String) {
        presenter!!.getMoviesWithTitle(text);

    }
    fun onFavouriteBtnClicke(movie:Movie )
    {
        var pos: Int = viewPager!!.getCurrentItem();
        if (pos == 0) {
            presenter!!.addMovieToFavourites(movie)
        }
    }

    override fun renderMovies(movies: List<Movie>?) {
        var pos: Int = viewPager!!.getCurrentItem();
        val currentFragment =
            supportFragmentManager.findFragmentByTag("android:switcher:" + R.id.viewPger.toString() + ":" + viewPager!!.currentItem)

        // var activeFragment : Fragment = adapter!!.getItem(pos);
        if (movies != null) {
            if (pos == 0) {

                (currentFragment as SearchFragment).viewListMovies(movies)
            }


        }


    }


}
//https://api.themoviedb.org/3/movie/550?api_key=cf52c65b5b064bd7282d2382cfe9768d
//https://api.themoviedb.org/3/search/movie?api_key=cf52c65b5b064bd7282d2382cfe9768d&language=en-US&query=Aliens%20vs%20Predator&page=1&include_adult=false
//https://api.themoviedb.org/3/search/movie?api_key=cf52c65b5b064bd7282d2382cfe9768d&query=Aliens%20vs%20Predator
//https://api.themoviedb.org/3/search/movie?api_key=cf52c65b5b064bd7282d2382cfe9768d&query=Aliens