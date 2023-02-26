package com.example.moviesbookingapp.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.example.moviesbookingapp.R
import com.example.moviesbookingapp.activities.adapters.AdapterBanner
import com.example.moviesbookingapp.activities.adapters.BottomNavWithViewPagerAdapter
import com.example.moviesbookingapp.activities.adapters.NowShowingCommingSoonAdapter
import com.example.moviesbookingapp.activities.fragments.CinemasFragment
import com.example.moviesbookingapp.activities.fragments.MoviesFragment
import com.example.moviesbookingapp.activities.fragments.ProfileFragment
import com.example.moviesbookingapp.activities.fragments.TicketsFragment
import com.google.android.material.navigation.NavigationBarView
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    lateinit var mBannerAdapter: AdapterBanner
    lateinit var mNowShowingCommingSoonAdapter: NowShowingCommingSoonAdapter
    lateinit var mBottomNavWithViewPagerAdapter: BottomNavWithViewPagerAdapter

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, HomeActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
//        setUpBottomNavigationWithViewPager()
        val citiesName = intent.getStringExtra("CITY_NAME").toString()
        tvCitiesName.text = citiesName
        setDefaultFragment()
        setUpBottomNavigation()


    }

    // Set Up Default Fragment onCreate
    private fun setDefaultFragment() {
        supportFragmentManager.beginTransaction().replace(R.id.flContainer, MoviesFragment())
            .commit()
    }

    //Set Up Bottom Navigation View
    private fun setUpBottomNavigation() {
        bottomNavigation.setOnItemSelectedListener(object :NavigationBarView.OnItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when (item.itemId) {
                    R.id.actionMovies -> supportFragmentManager.commit {
                        replace(R.id.flContainer, MoviesFragment())
                    }
                    R.id.actionCinema -> supportFragmentManager.commit {
                        replace(R.id.flContainer, CinemasFragment())
                    }
                    R.id.actionTickets -> supportFragmentManager.commit {
                        replace(R.id.flContainer, TicketsFragment())
                    }
                    R.id.actionProfile -> supportFragmentManager.commit {
                        replace(R.id.flContainer, ProfileFragment())
                    }

                }
                return true
            }
        })
    }


}



