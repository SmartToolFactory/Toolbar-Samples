package com.smarttoolfactory.toolbarsamples.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.smarttoolfactory.toolbarsamples.R
import com.smarttoolfactory.toolbarsamples.fragment.PostToolbarFragment

class Activity7FragmentToolbar : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity7_fragment_toolbar)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragmentContainerView, PostToolbarFragment())
            .commit()
    }
}