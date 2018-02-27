package com.pand.kotlin_eye.mvvm.viewmodel

import android.util.Log
import com.pand.kotlin_eye.mvvm.contract.HomePageContract
import com.pand.kotlin_eye.mvvm.model.HomePageModel
import com.pand.kotlin_eye.mvvm.ui.fragment.MainFragment

/**
 * Created by 李培生 on 2018/2/26 15:34.
 */
class HomePageViewModel(val view: MainFragment) : BaseViewModel(), HomePageContract.ViewModel {

val testdata= listOf('b','a','x')
    init {
    loadFirstData()
    }
    fun loadFirstData(){
        HomePageModel().requestData(1).subscribe({ it ->
           view.refresData(it)
        },{t -> Log.e(TAG,t.message) })
    }
}