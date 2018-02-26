package com.pand.kotlin_eye.mvvm.viewmodel

import com.pand.kotlin_eye.mvvm.contract.HomePageContract
import com.pand.kotlin_eye.mvvm.ui.fragment.MainFragment

/**
 * Created by 李培生 on 2018/2/26 15:34.
 */
class HomePageViewModel(view: MainFragment) : BaseViewModel(), HomePageContract.ViewModel {
val testdata= listOf('b','a','x')
    init {
       view.refresData(testdata)
    }
}