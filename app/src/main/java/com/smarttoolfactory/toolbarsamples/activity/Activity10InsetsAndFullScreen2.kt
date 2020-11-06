package com.smarttoolfactory.toolbarsamples.activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.ViewCompat
import androidx.core.view.updateLayoutParams
import androidx.core.view.updatePadding
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.smarttoolfactory.toolbarsamples.R
import com.smarttoolfactory.toolbarsamples.adapter.PostActivityStateAdapter

@Suppress("DEPRECATION")
class Activity10InsetsAndFullScreen2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity10_insets_fullscreen2)

        title = ""

        val rootView = findViewById<CoordinatorLayout>(R.id.coordinatorLayout)

        // Toolbar and Top items
        val appbar = findViewById<View>(R.id.appbar) as? AppBarLayout
        val toolbar = findViewById<View>(R.id.toolbar) as? Toolbar
        val collapsingToolbar =
            findViewById<View>(R.id.collapsingToolbar) as? CollapsingToolbarLayout
        val ivHeader = findViewById<View>(R.id.ivHeader) as? ImageView
        val tabLayout = findViewById<View>(R.id.tabLayout) as? TabLayout

        // Content
        val viewPager2 = findViewById<ViewPager2>(R.id.viewPager2)

        // Bottom Items
        val fab = findViewById<View>(R.id.fab) as? FloatingActionButton
        val bottomAppbar = findViewById<View>(R.id.bottomAppbar) as? BottomAppBar
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        viewPager2.adapter = PostActivityStateAdapter(this)
        tabLayout?.let {
            TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
                tab.text = "Tab $position"
            }.attach()
        }


        // Set fullscreen
        hideSystemUI(rootView, true)

        rootView.setOnApplyWindowInsetsListener { view, insets ->
            println("🎃 rootView padding: ${view.paddingTop}, inset top: ${insets.systemWindowInsetTop}")
//            view.onApplyWindowInsets(insets)

            toolbar?.updateLayoutParams<ViewGroup.MarginLayoutParams> {
                topMargin = insets.systemWindowInsetTop
            }

            view.requestLayout()
            insets
        }

        /*
            TOP INSETS
         */
//        appbar?.setOnApplyWindowInsetsListener { view, insets ->
//            view.updatePadding(top = insets.systemWindowInsetTop)
//
//            insets.consumeSystemWindowInsets()
//            val consumedInsets = insets.consumeSystemWindowInsets()
//            println(
//                "🔥 Appbar padding: ${view.paddingTop}, inset top: ${insets.systemWindowInsetTop}" +
//                        ", isConsumed: ${insets.isConsumed}" +
//                        "\nconsumedInsets: $consumedInsets"
//            )
//
//            insets
//        }
//        collapsingToolbar?.setOnApplyWindowInsetsListener { view, insets ->
//            view.updatePadding(top = insets.systemWindowInsetTop)
//
////            insets.consumeSystemWindowInsets()
//            val consumedInsets = insets.consumeSystemWindowInsets()
//            println(
//                "😆 collapsingToolbar padding: ${view.paddingTop}, inset top: ${insets.systemWindowInsetTop}" +
//                        ", isConsumed: ${insets.isConsumed}" +
//                        "\nconsumedInsets: $consumedInsets"
//            )
//            insets
//        }

//        ivHeader?.setOnApplyWindowInsetsListener { view, insets ->
//
//            view.updatePadding(top = insets.systemWindowInsetTop)
//
//            insets.consumeSystemWindowInsets()
//            val consumedInsets = insets.consumeSystemWindowInsets()
//            println(
//                "🚕 ivHeader padding: ${view.paddingTop}, inset top: ${insets.systemWindowInsetTop}" +
//         ", isConsumed: ${insets.isConsumed}" +
//                "\nconsumedInsets: $consumedInsets"
//            )
//            insets
//        }

        /*
            BOTTOM INSETS
         */


        // Add padding to bottom of BottomNavigationView to display it above NavigationBar
        bottomNav.setOnApplyWindowInsetsListener { view, insets ->


            view.updatePadding(bottom = 0)

            insets.consumeSystemWindowInsets()
            val consumedInsets = insets.consumeSystemWindowInsets()
            println(
                "🍺 BottomNav padding bottom: ${view.paddingBottom}, inset bottom: ${insets.systemWindowInsetBottom}" +
                        ", isConsumed: ${insets.isConsumed}" +
                        "\nconsumedInsets: $consumedInsets"
            )
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
