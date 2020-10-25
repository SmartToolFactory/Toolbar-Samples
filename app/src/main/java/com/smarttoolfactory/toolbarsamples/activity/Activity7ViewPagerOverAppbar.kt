package com.smarttoolfactory.toolbarsamples.activity

import android.os.Bundle
import android.util.DisplayMetrics
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.smarttoolfactory.toolbarsamples.R
import com.smarttoolfactory.toolbarsamples.adapter.PostActvitiyStateAdapter
import kotlin.math.abs

// TODO TabLayout Position is not moving correctly just above ViewPager
class Activity7ViewPagerOverAppbar : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity7_viewpager_over_appbar)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        val appbar = findViewById<AppBarLayout>(R.id.appbar)
        val viewPager2 = findViewById<ViewPager2>(R.id.viewPager2)
        val collapsingToolbar = findViewById<CollapsingToolbarLayout>(R.id.collapsingToolbar)
        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        val constraintLayout = findViewById<ConstraintLayout>(R.id.constraintLayout)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        viewPager2.adapter = PostActvitiyStateAdapter(this)

        TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
            tab.text = "Tab $position"
        }.attach()


        var initTransitionY = tabLayout.translationY
        tabLayout.post {
            initTransitionY = tabLayout.translationY
        }


        // Check if scrolling up or down
        var isScrollingUp = false
        var prevVerticalOffset = 0

        appbar.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->

            //Check if the view is collapsed
            if (abs(verticalOffset) >= appbar.totalScrollRange) {
                collapsingToolbar.title = "Collapsed"
            } else {
                collapsingToolbar.title = ""
            }

            isScrollingUp = (verticalOffset - prevVerticalOffset) <0


            if (isScrollingUp) {
                tabLayout.translationY =
                    initTransitionY + initTransitionY * (verticalOffset / appBarLayout.totalScrollRange.toFloat())
            }else {
                tabLayout.translationY = initTransitionY
            }


            println(
                "SCROLL verticalOffset: $verticalOffset, " +
                        "TAB translationY: ${tabLayout.translationY}, " +
                        "tab Y: ${tabLayout.y}, "+
                        "isScrollingUp: $isScrollingUp"
            )
        })
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main, menu)
        // return true so that the menu pop up is opened
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}