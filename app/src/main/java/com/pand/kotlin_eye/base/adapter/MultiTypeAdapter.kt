package com.pand.kotlin_eye.base.adapter

import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.annotation.LayoutRes
import android.support.v4.util.ArrayMap
import android.view.ViewGroup
import java.util.ArrayList

/**
 * @author： dwc
 * @date： 2018/2/8 15:55
 * @desc：多item的适配器
 */
open class MultiTypeAdapter constructor(context: Context, viewTypeToLayoutMap: Map<Int, Int>? = null) : BaseAdapter<Any>(context) {

    private var mCollectionViewType: ArrayList<Int>

    private val mItemTypeToLayoutMap = ArrayMap<Int, Int>()

    interface MultiViewTaper {
        fun getViewType(item: Any): Int
    }

    init {
        mCollection = ArrayList()
        mCollectionViewType = ArrayList()
        if (viewTypeToLayoutMap != null && !viewTypeToLayoutMap.isEmpty()) {
            mItemTypeToLayoutMap.putAll(viewTypeToLayoutMap)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder<*> {
        return BindingViewHolder(
                DataBindingUtil.inflate<ViewDataBinding>(mLayoutInflater, getLayoutRes(viewType), parent, false))
    }

    fun addViewTypeToLayoutMap(viewType: Int?, layoutRes: Int?) {
        mItemTypeToLayoutMap.put(viewType, layoutRes)
    }

    override fun getItemViewType(position: Int): Int {
        return mCollectionViewType[position]
    }

    operator fun set(viewModels: List<Any>, viewType: Int) {
        mCollection.clear()
        mCollectionViewType.clear()

        if (viewModels == null) {
            add(null, viewType)
        } else {
            addAll(viewModels, viewType)
        }
    }



    operator fun set(viewModels: List<Any>, viewTyper: MultiViewTaper) {
        mCollection.clear()
        mCollectionViewType.clear()

        addAll(viewModels, viewTyper)
    }

    private fun add(viewModel: Any?, viewType: Int) {
        if (viewModel != null) {
            mCollection.add(viewModel)
        }
        mCollectionViewType.add(viewType)
        notifyItemInserted(0)
    }

    fun add(position: Int, viewModel: Any, viewType: Int) {
        mCollection.add(position, viewModel)
        mCollectionViewType.add(position, viewType)
        notifyItemInserted(position)
    }

    private fun addAll(viewModels: List<Any>, viewType: Int) {
        mCollection.addAll(viewModels)
        for (i in viewModels) {
            mCollectionViewType.add(viewType)
        }
        notifyDataSetChanged()
    }

    fun addAll(position: Int, viewModels: List<Any>, viewType: Int) {
        mCollection.addAll(position, viewModels)
        for (i in viewModels.indices) {
            mCollectionViewType.add(position + i, viewType)
        }
        notifyItemRangeChanged(position, viewModels.size - position)
    }

    fun addAll(viewModels: List<Any>, multiViewTyper: MultiViewTaper) {
        mCollection.addAll(viewModels)
        for (i in viewModels.indices) {
            mCollectionViewType.add(multiViewTyper.getViewType(viewModels.get(i)!!))
        }
        notifyDataSetChanged()
    }

     override fun remove(position: Int) {
        mCollectionViewType.removeAt(position)
        super.remove(position)
    }

    override fun clear() {
        mCollectionViewType.clear()
        super.clear()
    }

    @LayoutRes
    private fun getLayoutRes(viewType: Int): Int {
        return mItemTypeToLayoutMap[viewType]!!
    }
}
