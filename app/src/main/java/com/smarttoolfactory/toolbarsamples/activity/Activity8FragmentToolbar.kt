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

        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragmentContainerView, PostToolbarFragment())
            .commit()
    }


    private fun hideSystemUI(isFullScreen: Boolean) {

        val decorView = window.decorView
        var uiOptions = View.SYSTEM_UI_FLAG_LAYOUT_STABLE

        if (isFullScreen) {
            // hide status bar
            uiOptions = (
                    uiOptions
//                            or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                            // Views can use nav bar space if set
                            or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                            // Removes Status bar
//                            or View.SYSTEM_UI_FLAG_FULLSCREEN
//                            // hide nav bar
//                            or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION

                    )
        }

        decorView.systemUiVisibility = uiOptions



        if (isFullScreen) {
//            setWindowFlag(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false)
//            window.statusBarColor = Color.TRANSPARENT
        } else {
//            setWindowFlag(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, true)
//            window.statusBarColor = ResourcesCompat.getColor(resources, R.color.purple_700, null)
        }

    }
}