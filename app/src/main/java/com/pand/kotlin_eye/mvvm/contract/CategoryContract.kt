package com.pand.kotlin_eye.mvvm.contract

import com.pand.kotlin_eye.mvvm.model.pojo.Category

/**
 * Created by 李培生 on 2018/3/5 9:48.
 */
interface CategoryContract {
    interface ViewModel {
      
        fun loadCategory()
    }
    
    interface View {
        fun reresh(it: ArrayList<Category>)
        fun loadmore()
    }
}