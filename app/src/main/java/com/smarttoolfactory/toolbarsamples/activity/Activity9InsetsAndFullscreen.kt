package com.smarttoolfactory.toolbarsamples.activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.appbar.AppBarLayout
import com.smarttoolfactory.toolbarsamples.R
import com.smarttoolfactory.toolbarsamples.fragment.PostListPlainFragment
import com.smarttoolfactory.toolbarsamples.util.doOnApplyWindowInsets

@Suppress("DEPRECATION")
class Activity9InsetsAndFullscreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity9_insets_fullscreen)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragmentContainerView, PostListPlainFragment())
            .commit()

        val rootView = findViewById<ConstraintLayout>(R.id.rootView)

        // Left these views nullable because i add/remove views while trying insetting with different layouts
        val appbar = findViewById<View>(R.id.appbar) as? AppBarLayout
        val toolbar = findViewById<View>(R.id.toolbar) as? Toolbar

        // 🔥 This is a mock View to apply top Inset to feel like status bar padding
        val statusBar = findViewById<View>(R.id.status_bar)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Set fullscreen
        hideSystemUI(rootView, true)


        // 🔥🔥 Set mock status bar height based on real height of status bar of device
        rootView.setOnApplyWindowInsetsListener { view, insets ->

            println("🎃 rootView padding: ${view.paddingTop}, inset top: ${insets.systemWindowInsetTop}")

            statusBar.run {
                layoutParams.height = insets.systemWindowInsetTop
                visibility = if (layoutParams.height > 0) View.VISIBLE else View.GONE
                requestLayout()
            }

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