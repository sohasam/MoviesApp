package com.example.moviesapp.ui.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.moviesapp.R
import com.example.moviesapp.ui.adapters.MyFragmentPagerAdapter
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
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

}
//https://api.themoviedb.org/3/movie/550?api_key=cf52c65b5b064bd7282d2382cfe9768d
