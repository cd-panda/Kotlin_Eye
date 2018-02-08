package com.pand.kotlin_eye.base.adapter

import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.annotation.LayoutRes
import android.view.ViewGroup
import java.util.ArrayList

/**
 * @author： dwc
 * @date： 2018/2/8 14:26
 * @desc：单item的适配器
 */
class SingleTypeAdapter<T>(context: Context, @get:LayoutRes private var layoutRes: Int) : BaseAdapter<T>(context) {

    interface Presenter<T> : BaseAdapter.Presenter {
        fun onItemClick(t: T)
    }

    init {
        mCollection = ArrayList()
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BindingViewHolder<*> {
        return BindingViewHolder(DataBindingUtil.inflate<ViewDataBinding>(mLayoutInflater, layoutRes, parent, false))
    }

    override fun getItemCount(): Int {
        return mCollection.size
    }

    fun add(viewModel: T) {
        mCollection.add(viewModel)
        notifyDataSetChanged()
    }

    fun add(position: Int, viewModel: T) {
        mCollection.add(position, viewModel)
        notifyDataSetChanged()
    }

    fun set(viewModels: List<T>) {
        mCollection.clear()
        addAll(viewModels)
    }

    fun addAll(viewModels: List<T>) {
        mCollection.addAll(viewModels)
        notifyDataSetChanged()
    }
}