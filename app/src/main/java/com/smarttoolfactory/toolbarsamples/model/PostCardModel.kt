package com.smarttoolfactory.toolbarsamples.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PostCardModel(val post: Post, @DrawableRes val drawableRes: Int) : Parcelable