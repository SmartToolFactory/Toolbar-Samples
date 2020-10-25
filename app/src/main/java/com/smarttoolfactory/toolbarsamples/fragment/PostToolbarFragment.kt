package com.smarttoolfactory.toolbarsamples.fragment

import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.appcompat.widget.ActionMenuView
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.smarttoolfactory.toolbarsamples.R
import com.smarttoolfactory.toolbarsamples.adapter.PostFragmentStateAdapter
import kotlin.math.abs


class PostToolbarFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_post_container, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val toolbar = view.findViewById<View>(R.id.toolbar) as Toolbar
        val appbar = view.findViewById<AppBarLayout>(R.id.appbar)
        val collapsingToolbar = view.findViewById<CollapsingToolbarLayout>(R.id.collapsingToolbar)

        val viewPager2 = view.findViewById<ViewPager2>(R.id.viewPager2)
        val tabLayout = view.findViewById<TabLayout>(R.id.tabLayout)

        viewPager2.adapter =
            PostFragmentStateAdapter(childFragmentManager, viewLifecycleOwner.lifecycle)


        toolbar.setNavigationOnClickListener {
            requireActivity().onBackPressed()
        }

        TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
            tab.text = "Tab $position"
        }.attach()

        var previous = false
        var collapsed = false

        appbar.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->


            //Check if the view is collapsed
            if (abs(verticalOffset) >= appbar.totalScrollRange) {
                collapsingToolbar.title = "Collapsed"
                collapsed = true
            } else {
                collapsingToolbar.title = ""
                collapsed = false
            }

            if (previous != collapsed) {
                updateToolbarIconsOnScrollChange(toolbar, collapsed)
                previous = collapsed

            }
        })

        updateToolbarIconsOnScrollChange(toolbar, collapsed)

    }

    private fun updateToolbarIconsOnScrollChange(toolbar: Toolbar, collapsed: Boolean) {

        // Set color filter
        val color = if (collapsed) {
            Color.WHITE
        } else {
            Color.parseColor("#F06292")
        }

        val colorFilter = PorterDuffColorFilter(color, PorterDuff.Mode.SRC_ATOP)

        // set back button color
        val backButton = (toolbar.getChildAt(0) as? ImageButton)
        backButton?.let {
            it.drawable.colorFilter = colorFilter
        }

        // Set menu items color
        val actionMenuView = (toolbar.getChildAt(1) as? ActionMenuView)

        actionMenuView?.let { menuView ->
            val childCount = menuView.childCount
            if (childCount > 0) {
                for (i in 0 until childCount) {
                    (menuView.getChildAt(i) as? ActionMenuItemView)?.let { view ->
                        view.compoundDrawables[0].colorFilter = colorFilter
                    }

                }
            }
        }
    }
}