package com.pand.kotlin_eye.base.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import com.pand.kotlin_eye.BR


/**
 * @author： dwc
 * @date： 2018/2/8 13:48
 * @desc：
 */
abstract class BaseAdapter<T>(context: Context) : RecyclerView.Adapter<BindingViewHolder<*>>() {
    protected var mLayoutInflater: LayoutInflater = LayoutInflater.from(context)
    protected lateinit var mCollection: MutableList<T>
    private lateinit var presenter: Presenter
    private var mDecorator: Decorator? = null

    interface Presenter

    interface Decorator {
        fun decorator(holder: BindingViewHolder<*>, position: Int, viewType: Int)
    }

    override fun onBindViewHolder(holder: BindingViewHolder<*>, position: Int) {
        var item = mCollection!![position]
        holder.binding.setVariable(BR.item, item)
        holder.binding.setVariable(BR.presenter, presenter)
        holder.binding.executePendingBindings()
        if (mDecorator != null) {
            mDecorator!!.decorator(holder, position, getItemViewType(position))
        }
    }
    override fun getItemCount(): Int {
        return mCollection!!.size
    }
    open fun remove(position: Int) {
        mCollection!!.removeAt(position)
        notifyItemRemoved(position)
    }

    open fun clear() {
        mCollection!!.clear()
        notifyDataSetChanged()
    }

    fun setDecorator(decorator: Decorator) {
        mDecorator = decorator
    }

}