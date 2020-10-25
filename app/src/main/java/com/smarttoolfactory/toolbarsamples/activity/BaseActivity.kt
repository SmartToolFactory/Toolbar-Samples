package com.smarttoolfactory.toolbarsamples.activity

import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.smarttoolfactory.toolbarsamples.R
import com.smarttoolfactory.toolbarsamples.model.Post
import com.smarttoolfactory.toolbarsamples.model.PostCardModel
import java.util.*
import kotlin.collections.ArrayList

open class BaseActivity : AppCompatActivity() {

    internal fun generateMockPosts(): List<PostCardModel> {
        val postList = ArrayList<PostCardModel>()
        val random = Random()

        repeat(30) {
            val randomNum = random.nextInt(5)
            val title = "Title $randomNum"
            val postBody = getString(R.string.lorem)
            val post = Post(it, it, title, postBody)
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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main, menu)
        // return true so that the menu pop up is opened
        return true
    }

}