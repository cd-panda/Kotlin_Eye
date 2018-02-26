package com.pand.kotlin_eye.mvvm.contract

/**
 * Created by 李培生 on 2018/2/26 15:32.
 */
interface HomePageContract {
    interface View :IView{
    fun refresData(testdata: List<Char>):Unit
    }
    interface ViewModel
}