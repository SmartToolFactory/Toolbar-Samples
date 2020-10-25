package com.smarttoolfactory.toolbarsamples.activity

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.smarttoolfactory.toolbarsamples.R
import com.smarttoolfactory.toolbarsamples.fragment.PostToolbarFragment

@Suppress("DEPRECATION")
class Activity7FragmentToolbar : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity7_fragment_toolbar)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragmentContainerView, PostToolbarFragment())
            .commit()

        // TODO Fix FullScreen issue and Insets
//        supportFragmentManager.addOnBackStackChangedListener {
//
//            val backStackEntryCount = supportFragmentManager.backStackEntryCount
//            val fragCount = supportFragmentManager.fragments.size
//            val fragment = supportFragmentManager.fragments.firstOrNull()!!
//
//            if (backStackEntryCount == 1) {
//                hideSystemUI(isFullScreen = true)
//            } else {
//                hideSystemUI(isFullScreen = false)
//            }
//        }
    }


    private fun hideSystemUI(isFullScreen: Boolean) {

        val decorView = window.decorView
        var uiOptions = View.SYSTEM_UI_FLAG_LAYOUT_STABLE

        if (isFullScreen) {
            // hide status bar
            uiOptions = (
                    uiOptions
                            or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                            // Views can use nav bar space if set
//            or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            // Removes Status bar
                            or View.SYSTEM_UI_FLAG_FULLSCREEN
                    // hide nav bar
//                            or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION

                    )
        }

        decorView.systemUiVisibility = uiOptions



        if (isFullScreen) {
//            setWindowFlag(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false)
            window.statusBarColor = Color.TRANSPARENT
        } else {
//            setWindowFlag(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, true)
            window.statusBarColor = ResourcesCompat.getColor(resources, R.color.purple_700, null)
        }

    }

    private fun setWindowFlag(bits: Int, on: Boolean) {
        val win = window
        val winParams = win.attributes
        if (on) {
            winParams.flags = winParams.flags or bits
        } else {
            winParams.flags = winParams.flags and bits.inv()
        }
        win.attributes = winParams
    }
}