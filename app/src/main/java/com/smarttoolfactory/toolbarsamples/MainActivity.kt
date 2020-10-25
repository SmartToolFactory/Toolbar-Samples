package com.smarttoolfactory.toolbarsamples

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.smarttoolfactory.toolbarsamples.databinding.ActivityMainBinding
import com.smarttoolfactory.toolbarsamples.activity.*
import com.smarttoolfactory.toolbarsamples.model.ActivityClassModel
import java.util.*

class MainActivity : AppCompatActivity(), BaseAdapter.OnRecyclerViewItemClickListener {

    private val activityClassModels = ArrayList<ActivityClassModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        title = "MainActivity"

        val activityMainBinding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        addChapters()

        val recyclerView = activityMainBinding.recyclerView

        recyclerView.apply {

            // Use fixed size for performance
            setHasFixedSize(true)

            // use a linear layout manager
            layoutManager = LinearLayoutManager(this@MainActivity)

            // Add vertical divider
            addItemDecoration(
                DividerItemDecoration(
                    this@MainActivity,
                    DividerItemDecoration.VERTICAL
                )
            )

            // Add Adapter
            recyclerView.adapter = ChapterSelectionAdapter(activityClassModels).apply {
                setOnItemClickListener(this@MainActivity)
            }
        }
    }

    private fun addChapters() {

        // Add Activities to list to be displayed on RecyclerView
        activityClassModels.add(
            ActivityClassModel(
                Activity1CollapsingToolbar1::class.java,
                Activity1CollapsingToolbar1::class.java.simpleName
            )
        )

        activityClassModels.add(
            ActivityClassModel(
                Activity2CollapsingToolbar2::class.java,
                Activity2CollapsingToolbar2::class.java.simpleName
            )
        )

        activityClassModels.add(
            ActivityClassModel(
                Activity3CollapsingToolbarScrollFlags::class.java,
                Activity3CollapsingToolbarScrollFlags::class.java.simpleName
            )
        )

        activityClassModels.add(
            ActivityClassModel(
                Activity4ToolbarAndTabLayoutScroll::class.java,
                Activity4ToolbarAndTabLayoutScroll::class.java.simpleName
            )
        )

        activityClassModels.add(
            ActivityClassModel(
                Activity5CollapseTabsToolbar::class.java,
                Activity5CollapseTabsToolbar::class.java.simpleName
            )
        )

        activityClassModels.add(
            ActivityClassModel(
                Activity6ParallaxTransparentImageTabs::class.java,
                Activity6ParallaxTransparentImageTabs::class.java.simpleName
            )
        )
    }

    @Override
    override fun onItemClicked(view: View, position: Int) {
        Intent(this@MainActivity, activityClassModels[position].clazz).also {
            startActivity(it)
        }
    }
}