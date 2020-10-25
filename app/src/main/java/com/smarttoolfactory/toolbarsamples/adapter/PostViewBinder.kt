package com.smarttoolfactory.toolbarsamples.adapter

import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.smarttoolfactory.toolbarsamples.R
import com.smarttoolfactory.toolbarsamples.databinding.ItemPostBinding
import com.smarttoolfactory.toolbarsamples.model.PostCardModel


class PostCardViewBinder(
    private val onItemClick: ((ItemPostBinding, PostCardModel) -> Unit)? = null
) : MappableItemViewBinder<PostCardModel, PostCardViewHolder>(PostCardModel::class.java) {

    override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return PostCardViewHolder(
            parent.inflate(getItemLayoutResource()),
            onItemClick
        )
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
    private val binding: ItemPostBinding,
    private val onItemClick: ((ItemPostBinding, PostCardModel) -> Unit)? = null
) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(model: PostCardModel) {

        val post = model.post
        binding.tvTitle.text = post.title
        binding.tvBody.text = post.body

        setImageUrl(binding.ivPhoto, model.drawableRes)

        binding.constraintLayout.setOnClickListener {
            onItemClick?.invoke(binding, model)
        }
    }

    private fun setImageUrl(view: ImageView, drawableRes: Int) {

        try {
            view.load(drawableRes)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}