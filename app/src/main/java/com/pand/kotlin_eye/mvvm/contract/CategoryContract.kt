package com.pand.kotlin_eye.mvvm.contract

/**
 * Created by 李培生 on 2018/3/5 9:48.
 */
interface CategoryContract {
    interface ViewModel {
      
        fun loadCategory()
    }
    
    interface View {
        fun reresh()
        fun loadmore()
    }
}