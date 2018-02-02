package com.pand.kotlin_eye.mvvm.viewmodel

import com.pand.kotlin_eye.mvvm.contract.SplashContract
import com.pand.kotlin_eye.mvvm.ui.activity.SplashActivity
import com.pand.kotlin_eye.network.ApiClient
import com.pand.kotlin_eye.network.NetworkScheduler
import com.trello.rxlifecycle2.android.ActivityEvent
import com.trello.rxlifecycle2.kotlin.bindUntilEvent
import java.util.*

/**
 * Created by 李培生 on 2018/2/2 9:57.
 */
class SplashViewModel(val splashActivity: SplashActivity) : BaseViewModel(), SplashContract.ViewModel {
    /**
     * 从gankio 获取图片作为启动页
     */
    override fun loadImage() {
        ApiClient.instance.service.getSplash(Calendar.getInstance().get(Calendar.MONTH)+1,Calendar.getInstance().get(Calendar.DAY_OF_MONTH))
                .compose(NetworkScheduler.compose())
                .bindUntilEvent(splashActivity, ActivityEvent.DESTROY)
                .subscribe { t -> splashActivity.loadImg(t?.results!![0].url) }
    }
    
}