package com.smarttoolfactory.toolbarsamples.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.smarttoolfactory.toolbarsamples.R
import com.smarttoolfactory.toolbarsamples.adapter.ItemBinder
import com.smarttoolfactory.toolbarsamples.adapter.PostCardViewBinder
import com.smarttoolfactory.toolbarsamples.adapter.SingleViewBinderListAdapter

class Activity1CollapsingToolbar1 : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity1_collapsing_toolbar1)

        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val postCardViewBinder = PostCardViewBinder()

        val listAdapter = SingleViewBinderListAdapter(postCardViewBinder as ItemBinder)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView?.apply {
            this.adapter = listAdapter
            layoutManager = LinearLayoutManager(this@Activity1CollapsingToolbar1)
        }

        listAdapter.submitList(generateMockPosts())
    }


}