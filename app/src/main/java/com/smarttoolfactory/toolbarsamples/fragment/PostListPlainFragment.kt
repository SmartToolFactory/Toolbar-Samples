package com.smarttoolfactory.toolbarsamples.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.smarttoolfactory.toolbarsamples.R
import com.smarttoolfactory.toolbarsamples.adapter.ItemBinder
import com.smarttoolfactory.toolbarsamples.adapter.PostCardViewBinder
import com.smarttoolfactory.toolbarsamples.adapter.SingleViewBinderListAdapter
import com.smarttoolfactory.toolbarsamples.model.Post
import com.smarttoolfactory.toolbarsamples.model.PostCardModel
import java.util.*
import kotlin.collections.ArrayList

@Suppress("UNCHECKED_CAST")
class PostListPlainFragment : Fragment() {

    private val data by lazy {
        generateMockPosts()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_post_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val postCardViewBinder = PostCardViewBinder()

        val listAdapter = SingleViewBinderListAdapter(postCardViewBinder as ItemBinder)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView?.apply {
            this.adapter = listAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
        listAdapter.submitList(data)
    }


    private fun generateMockPosts(): List<PostCardModel> {
        val postList = ArrayList<PostCardModel>()
        val random = Random()

        repeat(20) {
            val randomNum = random.nextInt(5)
            val title = "Title $randomNum"
            val post = Post(it, it, title)
            postList.add(PostCardModel(post, getDrawableRes(randomNum)))
        }

        return postList
    }

    private fun getDrawableRes(userId: Int): Int {
        return when {
            userId % 6 == 0 -> {
                R.drawable.avatar_1_raster
            }
            userId % 6 == 1 -> {
                R.drawable.avatar_2_raster
            }
            userId % 6 == 2 -> {
                R.drawable.avatar_3_raster
            }
            userId % 6 == 3 -> {
                R.drawable.avatar_4_raster
            }
            userId % 6 == 4 -> {
                R.drawable.avatar_5_raster
            }
            else -> {
                R.drawable.avatar_6_raster
            }
        }
    }

}