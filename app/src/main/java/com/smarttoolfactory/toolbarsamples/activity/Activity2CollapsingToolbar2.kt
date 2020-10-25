package com.smarttoolfactory.toolbarsamples.activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.smarttoolfactory.toolbarsamples.R


class Activity2CollapsingToolbar2 : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity2_collapsing_toolbar2)

        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val fab = findViewById<View>(R.id.fab) as FloatingActionButton
        fab.setOnClickListener { v ->
            Snackbar.make(v, "Hello World", Snackbar.LENGTH_SHORT).show()
        }
    }


}