package com.pand.kotlin_eye.base.adapter

import android.databinding.BindingAdapter
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 * @author： dwc
 * @date： 2018/2/8 13:42
 * @desc：
 */
class BindingViewHolder<out T : ViewDataBinding>(val binding: T) : RecyclerView.ViewHolder(binding.root) {
    companion object {
        @BindingAdapter("image")
        fun loadimage(view: ImageView, url: String) {
            Glide.with(view.context).load(url).into(view)
        }
    }
}