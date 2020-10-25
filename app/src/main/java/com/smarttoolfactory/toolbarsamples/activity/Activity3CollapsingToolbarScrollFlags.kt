package com.smarttoolfactory.toolbarsamples.activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.widget.Toolbar
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.AppBarLayout.LayoutParams.*
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.smarttoolfactory.toolbarsamples.R


/**
 * Setting scroll flags changes behavior when appbar should expanded size
 * or snap from expanded size to collapsed size only
 *
 */
class Activity3CollapsingToolbarScrollFlags : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity3_collapsing_toolbar_scroll_flags)

        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title = "Hello World"

        val fab = findViewById<View>(R.id.fab) as FloatingActionButton
        fab.setOnClickListener { v: View? ->
            Snackbar.make(
                v!!,
                "Hello World",
                Snackbar.LENGTH_SHORT
            ).show()
        }

        val collapsingToolbar = findViewById<CollapsingToolbarLayout>(R.id.collapsingToolbar)
        val params = collapsingToolbar.layoutParams as AppBarLayout.LayoutParams
        params.scrollFlags = (SCROLL_FLAG_SCROLL or SCROLL_FLAG_SNAP)


        collapsingToolbar.layoutParams = params


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        } else if (item.itemId == R.id.menu_item_more) {

            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_flags, menu)
        // return true so that the menu pop up is opened
        return true
    }



}