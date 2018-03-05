package com.pand.kotlin_eye.mvvm.viewmodel

import android.util.Log
import com.pand.kotlin_eye.mvvm.contract.CategoryContract
import com.pand.kotlin_eye.mvvm.model.CategoryModel

/**
 * Created by 李培生 on 2018/3/5 9:52.
 */
class CategoryViewModel:BaseViewModel(),CategoryContract.ViewModel {
     val mModel= CategoryModel()
    
    init {
        loadCategory()
    }
    override fun loadCategory() {
    mModel.loadCategory().subscribe({it->
        Log.e(TAG,it.toString())
    })
    }
}