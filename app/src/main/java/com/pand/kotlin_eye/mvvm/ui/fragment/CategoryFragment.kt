package com.pand.kotlin_eye.mvvm.ui.fragment


import android.graphics.Rect
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View

import com.pand.kotlin_eye.R
import com.pand.kotlin_eye.base.BaseFragment
import com.pand.kotlin_eye.base.adapter.SingleTypeAdapter
import com.pand.kotlin_eye.databinding.FragmentCategoryBinding
import com.pand.kotlin_eye.mvvm.contract.CategoryContract
import com.pand.kotlin_eye.mvvm.model.pojo.Category
import com.pand.kotlin_eye.mvvm.viewmodel.CategoryViewModel


/**
 * A simple [Fragment] subclass.
 * Use the [CategoryFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CategoryFragment : BaseFragment<CategoryViewModel, FragmentCategoryBinding>() ,CategoryContract.View{
    override fun loadmore() {
    
    }
    
    override fun reresh(it: ArrayList<Category>) {
        adapter.set(it)
    }
    
    lateinit var recyclerView:RecyclerView
    lateinit var adapter:SingleTypeAdapter<Category>
    override fun initView() {
        recyclerView=mBinding.recyclerview
        adapter= SingleTypeAdapter(activity,R.layout.item_category)
        adapter.setDecorator(CategoryViewModel.CategoryPresenter(activity))
        recyclerView.layoutManager=GridLayoutManager(activity,2)
        recyclerView.adapter=adapter
        recyclerView.addItemDecoration(object :RecyclerView.ItemDecoration(){
//            设置间隔
            override fun getItemOffsets(outRect: Rect, itemPosition: Int, parent: RecyclerView?) {
                outRect.top=5
                outRect.right=5
            }
        })
    }
    
    override fun setViewModel() {
    
    }
    
    override fun getViewModel()= CategoryViewModel(this)
    
    override fun getLayoutRes()= R.layout.fragment_category
    
  
  

   
}
