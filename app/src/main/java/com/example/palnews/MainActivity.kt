package com.example.palnews

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabItem
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    lateinit var tabLayout: TabLayout
    lateinit var mHome: TabItem
    lateinit var mScience: TabItem
    lateinit var mBusiness: TabItem
    lateinit var mSports: TabItem
    lateinit var mTechnology: TabItem
    lateinit var mHealth: TabItem
    lateinit var mEntertainment: TabItem
    lateinit var pagerAdapter: PagerAdapter
    private lateinit var mToolbar: Toolbar

    val api: String = "dda4d2f20deb4dc1902db6e81d1c547b"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mToolbar = findViewById(R.id.titleNews)
        setSupportActionBar(mToolbar)

        /*mHome = findViewById(R.id.home)
        mBusiness = findViewById(R.id.business)
        mEntertainment = findViewById(R.id.entertainment)
        mHealth = findViewById(R.id.health)
        mScience = findViewById(R.id.science)
        mSports = findViewById(R.id.sports)
        mTechnology = findViewById(R.id.technology)

         */

        val viewPager: ViewPager = findViewById(R.id.fragmentContainer)
        tabLayout = findViewById(R.id.category)

        pagerAdapter = PagerAdapter(supportFragmentManager,7)
        viewPager.adapter = pagerAdapter


        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{

            override fun onTabSelected(tab: TabLayout.Tab?) {
                viewPager.currentItem = tab!!.position

                if(tab.position == 0 || tab.position == 1 || tab.position == 2 || tab.position == 3 || tab.position == 4 || tab.position == 5 || tab.position == 6){

                    pagerAdapter.notifyDataSetChanged()

                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                pagerAdapter.notifyDataSetChanged()
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                viewPager.currentItem = tab!!.position

                if(tab.position == 0 || tab.position == 1 || tab.position == 2 || tab.position == 3 || tab.position == 4 || tab.position == 5 || tab.position == 6){

                    pagerAdapter.notifyDataSetChanged()

                }
            }


        })

        viewPager.addOnPageChangeListener(object: TabLayout.TabLayoutOnPageChangeListener(tabLayout){})

    }

}

