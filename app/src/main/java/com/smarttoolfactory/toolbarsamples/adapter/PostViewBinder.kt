package com.smarttoolfactory.toolbarsamples.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.smarttoolfactory.toolbarsamples.R
import com.smarttoolfactory.toolbarsamples.model.PostCardModel


class PostCardViewBinder(private val onItemCLick: ((PostCardModel, Int) -> Unit)? = null) :
    MappableItemViewBinder<PostCardModel, PostCardViewHolder>(PostCardModel::class.java) {

    override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        return PostCardViewHolder(view, onItemCLick)
    }

    override fun bindViewHolder(model: PostCardModel, viewHolder: PostCardViewHolder) {
        viewHolder.bind(model)
    }

    override fun getItemLayoutResource(): Int {
        return R.layout.item_post
    }

    override fun areItemsTheSame(oldItem: PostCardModel, newItem: PostCardModel): Boolean {
        return oldItem.post == newItem.post
    }

    override fun areContentsTheSame(oldItem: PostCardModel, newItem: PostCardModel): Boolean {
        return oldItem == newItem
    }
}

class PostCardViewHolder(
    val view: View,
    private val onItemCLick: ((PostCardModel, Int) -> Unit)? = null
) : RecyclerView.ViewHolder(view) {

    fun bind(model: PostCardModel) {

        val post = model.post

        val ivPhoto = view.findViewById<ImageView>(R.id.ivPhoto)
        val tvTitle = view.findViewById<TextView>(R.id.tvTitle)

        tvTitle.text = post.title

        ivPhoto.load(model.drawableRes)

        view.setOnClickListener {
            onItemCLick?.invoke(model, bindingAdapterPosition)
        }
    }


}