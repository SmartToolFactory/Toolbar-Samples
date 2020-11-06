package com.smarttoolfactory.toolbarsamples.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.smarttoolfactory.toolbarsamples.R
import com.smarttoolfactory.toolbarsamples.fragment.PostToolbarFragment

@Suppress("DEPRECATION")
class Activity8FragmentToolbar : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity8_fragment_toolbar)

        val coordinatorLayout = findViewById<CoordinatorLayout>(R.id.coordinatorLayout)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragmentContainerView, PostToolbarFragment())
            .commit()

        supportFragmentManager.addOnBackStackChangedListener {
            val backStackEntryCount = supportFragmentManager.backStackEntryCount
            hideSystemUI(coordinatorLayout, backStackEntryCount != 0)
        }
    }

    private fun hideSystemUI(view: View = window.decorView, isFullScreen: Boolean) {

        var uiOptions = View.SYSTEM_UI_FLAG_LAYOUT_STABLE

        if (isFullScreen) {
            // hide status bar
            uiOptions = (
                    uiOptions
//                            or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                            // Views can use nav bar space if set
                            // Hide navigation is not necessary if you don't intend to have scrolling below navbar's position
                            or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            // Fullscreen
                            or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                            // Removes Status bar
//                            or View.SYSTEM_UI_FLAG_FULLSCREEN
//                            // Removes nav bar
//                            or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    )
        }

        view.systemUiVisibility = uiOptions
    }
}