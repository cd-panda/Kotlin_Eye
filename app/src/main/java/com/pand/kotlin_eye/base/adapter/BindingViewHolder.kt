package com.pand.kotlin_eye.base.adapter

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView

/**
 * @author： dwc
 * @date： 2018/2/8 13:42
 * @desc：
 */
class BindingViewHolder<out T : ViewDataBinding>(val binding: T) : RecyclerView.ViewHolder(binding.root)