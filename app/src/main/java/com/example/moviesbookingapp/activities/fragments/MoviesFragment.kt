package com.example.moviesbookingapp.activities.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.moviesbookingapp.R
import com.example.moviesbookingapp.activities.adapters.AdapterBanner
import com.example.moviesbookingapp.activities.adapters.NSCSAdapter
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_movies.*
import kotlinx.android.synthetic.main.fragment_movies.view.*


class MoviesFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setUpBanner(view)
        setUpNowShowing(view)

        super.onViewCreated(view, savedInstanceState)

    }

    private fun setUpNowShowing(view: View) {
        val nscsAdapter = NSCSAdapter(this)
        view.viewpagerNowShowing.adapter = nscsAdapter

        TabLayoutMediator(view.tabLayoutNsCs, viewpagerNowShowing) { tab, position ->
            when (position) {

                0 -> tab.text = "Now Showing"
                else -> tab.text = "Coming Soon"

            }
        }.attach()
    }

    private fun setUpBanner(view: View) {
        view.viewPagerBanner.adapter = AdapterBanner(this)
        dotsIndicatorBanner.attachTo(viewPagerBanner)
    }


}