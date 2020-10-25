package com.smarttoolfactory.toolbarsamples.activity

import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver.OnGlobalLayoutListener
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.appcompat.widget.ActionMenuView
import androidx.appcompat.widget.Toolbar
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.smarttoolfactory.toolbarsamples.R
import com.smarttoolfactory.toolbarsamples.adapter.PostActvitiyStateAdapter
import java.util.*
import kotlin.math.abs


class Activity5CollapseTabsToolbar : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity5_collapse_tabs_toolbar)

        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        val appbar = findViewById<AppBarLayout>(R.id.appbar)
        val collapsingToolbar = findViewById<CollapsingToolbarLayout>(R.id.collapsingToolbar)

        val viewPager2 = findViewById<ViewPager2>(R.id.viewPager2)
        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        viewPager2.adapter = PostActvitiyStateAdapter(this)
        TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
            tab.text = "Tab $position"
        }.attach()

        appbar.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->

            //Check if the view is collapsed
            if (abs(verticalOffset) >= appbar.totalScrollRange) {
                collapsingToolbar.title = "Collapsed"
            } else {
                collapsingToolbar.title = ""
            }
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