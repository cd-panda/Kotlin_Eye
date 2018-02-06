package com.pand.kotlin_eye.mvvm.contract

/**
 * Created by 李培生 on 2018/2/2 9:52.
 */
interface SplashContract {
    interface View : IView {
        fun loadImg(url: String?)
    }
    
    interface ViewModel {
        fun loadImage()
    }
}