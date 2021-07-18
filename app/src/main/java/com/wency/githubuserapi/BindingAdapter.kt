package com.wency.githubuserapi

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.wency.githubuserapi.data.User


@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = it.toUri().buildUpon().build()
        Glide.with(imgView.context)
            .load(imgUri)
            .centerCrop()
            .circleCrop()
            .into(imgView)
    }
}

@BindingAdapter("userAdapter")
fun userBindRecyclerView(recyclerView: RecyclerView, data: List<User>?) {
    data?.let {
        recyclerView.adapter?.apply {
            when(this){
                is UserAdapter -> submitList(it)
            }
        }
    }
}