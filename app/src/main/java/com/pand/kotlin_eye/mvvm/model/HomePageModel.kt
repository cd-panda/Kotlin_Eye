package com.pand.kotlin_eye.mvvm.model

import com.pand.kotlin_eye.network.ApiClient
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by 李培生 on 2018/2/27 9:43.
 */
class HomePageModel {
    fun requestData(number: Number) = ApiClient.instance.service.getHomePageData(number).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
    
}