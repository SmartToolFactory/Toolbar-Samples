package com.smarttoolfactory.toolbarsamples.activity

import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayout
import android.os.Bundle
import android.view.Menu
import com.smarttoolfactory.toolbarsamples.R
import android.view.View
import com.google.android.material.appbar.CollapsingToolbarLayout
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.smarttoolfactory.toolbarsamples.adapter.PostActvitiyStateAdapter

class Activity6ParallaxTransparentImageTabs : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity6_parallax_image_tabs)

      val  toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val viewPager2 = findViewById<ViewPager2>(R.id.viewPager2)

        viewPager2.adapter = PostActvitiyStateAdapter(this)

        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)

        TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
            tab.text = "Tab $position"
        }.attach()

        val collapsingToolbarLayout = findViewById<View>(
            R.id.collapsingToolbar
        ) as CollapsingToolbarLayout

        collapsingToolbarLayout.isTitleEnabled = false

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