package com.example.moviesapp.ui.adapters

import android.content.Context
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.moviesapp.ui.fragments.FavouriteFragment
import com.example.moviesapp.ui.fragments.SearchFragment

class MyFragmentPagerAdapter (contxt:Context,var totalTabs:Int,fm: FragmentManager): FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {


        when(position)
        {

                0->{return SearchFragment()}
            else->{return  FavouriteFragment()}
        }

    }

    override fun getCount(): Int {


        return totalTabs
    }
}