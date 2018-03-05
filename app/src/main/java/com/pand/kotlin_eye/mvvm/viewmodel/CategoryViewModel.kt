package com.pand.kotlin_eye.mvvm.viewmodel

import android.support.v4.app.FragmentActivity
import com.bumptech.glide.Glide
import com.pand.kotlin_eye.R
import com.pand.kotlin_eye.base.adapter.BaseAdapter
import com.pand.kotlin_eye.base.adapter.BindingViewHolder
import com.pand.kotlin_eye.databinding.ItemCategoryBinding
import com.pand.kotlin_eye.mvvm.contract.CategoryContract
import com.pand.kotlin_eye.mvvm.model.CategoryModel

/**
 * Created by 李培生 on 2018/3/5 9:52.
 */
class CategoryViewModel(var view: CategoryContract.View) : BaseViewModel(), CategoryContract.ViewModel {
    val mModel = CategoryModel()
    
    init {
        loadCategory()
    }
    
    override fun loadCategory() {
        mModel.loadCategory().subscribe({ it ->
            view.reresh(it)
        })
    }
    
    class CategoryPresenter(var activity: FragmentActivity) : BaseAdapter.Decorator {
        override fun decorator(holder: BindingViewHolder<*>, position: Int, viewType: Int) {
            var bind: ItemCategoryBinding = holder.binding as ItemCategoryBinding
            var item = bind.item
            Glide.with(activity).load(item.bgPicture).into(bind.bgImg)
            bind.tvCategory.text = "#${item.name}"
        }
    }
}