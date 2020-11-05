package com.smarttoolfactory.toolbarsamples.activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.ViewCompat
import androidx.core.view.updatePadding
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.smarttoolfactory.toolbarsamples.R
import com.smarttoolfactory.toolbarsamples.adapter.PostActvitiyStateAdapter
import kotlin.math.abs

@Suppress("DEPRECATION")
class Activity9InsetsAndFullscreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity9_insets_fullscreen)

        val rootView = findViewById<CoordinatorLayout>(R.id.coordinatorLayout)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        val appbar = findViewById<AppBarLayout>(R.id.appbar)
        val collapsingToolbar = findViewById<CollapsingToolbarLayout>(R.id.collapsingToolbar)
        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        val ivHeader = findViewById<ImageView>(R.id.ivHeader)

        val viewPager2 = findViewById<ViewPager2>(R.id.viewPager2)

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


        // Set fullscreen
        hideSystemUI(rootView, true)

        appbar.setOnApplyWindowInsetsListener { view, insets ->

            Toast.makeText(
                applicationContext,
                "Appbar padding: ${appbar.paddingTop}, inset top: ${insets.systemWindowInsetTop}",
                Toast.LENGTH_SHORT
            ).show()
//            view.updatePadding(top = view.paddingTop + insets.systemWindowInsetTop)
            insets
        }

//        collapsingToolbar.setOnApplyWindowInsetsListener { view, insets ->
//
//            Toast.makeText(
//                applicationContext,
//                "collapsingToolbar padding: ${appbar.paddingTop}, inset top: ${insets.systemWindowInsetTop}",
//                Toast.LENGTH_SHORT
//            ).show()
//            view.updatePadding(top = view.paddingTop + insets.systemWindowInsetTop)
//            insets
//        }
//
//        toolbar.setOnApplyWindowInsetsListener { view, insets ->
//
//            Toast.makeText(
//                applicationContext,
//                "toolbar padding: ${appbar.paddingTop}, inset top: ${insets.systemWindowInsetTop}",
//                Toast.LENGTH_SHORT
//            ).show()
////            view.updatePadding(top = insets.systemWindowInsetTop)
//            insets
//        }

        ivHeader.setOnApplyWindowInsetsListener { view, insets ->

            Toast.makeText(
                applicationContext,
                "ivHeader padding: ${appbar.paddingTop}, inset top: ${insets.systemWindowInsetTop}",
                Toast.LENGTH_SHORT
            ).show()
            view.updatePadding(top = view.paddingTop + insets.systemWindowInsetTop)
            insets
        }

        // Add padding to bottom of BottomNavigationView to display it above NavigationBar
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        bottomNav.requestApplyInsetsWhenAttached()
        bottomNav.setOnApplyWindowInsetsListener { view, insets ->
            view.updatePadding(top = view.paddingTop + insets.systemWindowInsetTop)
            Toast.makeText(
                applicationContext,
                "BottomNav Inset: ${insets.systemWindowInsetBottom}",
                Toast.LENGTH_SHORT
            ).show()
            insets
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
                            or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                            // Removes Status bar
//                            or View.SYSTEM_UI_FLAG_FULLSCREEN
//                            // hide nav bar
//                            or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    )
        }

        view.systemUiVisibility = uiOptions
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

fun View.requestApplyInsetsWhenAttached() {
    if (isAttachedToWindow) {
        // We're already attached, just request as normal
        requestApplyInsets()
    } else {
        // We're not attached to the hierarchy, add a listener to
        // request when we are
        addOnAttachStateChangeListener(object : View.OnAttachStateChangeListener {
            override fun onViewAttachedToWindow(v: View) {
                v.removeOnAttachStateChangeListener(this)
                v.requestApplyInsets()
            }

            override fun onViewDetachedFromWindow(v: View) = Unit
        })
    }
}