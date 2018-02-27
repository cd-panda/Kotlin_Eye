package com.pand.kotlin_eye.mvvm.contract

import com.pand.kotlin_eye.mvvm.model.pojo.HomeBean

/**
 * Created by 李培生 on 2018/2/26 15:32.
 */
interface HomePageContract {
    interface View :IView{
    fun refresData(data: ArrayList<HomeBean.Issue.Item>):Unit
        fun loadMoreEnd()
        fun refreshEnd()
    }
    interface ViewModel{
        fun loadMoreData()
    }
}