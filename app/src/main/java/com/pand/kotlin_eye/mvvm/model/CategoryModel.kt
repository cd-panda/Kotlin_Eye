package com.pand.kotlin_eye.mvvm.model

import com.pand.kotlin_eye.network.ApiClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by 李培生 on 2018/3/5 9:51.
 */
class CategoryModel :BaseModel(){
    fun loadCategory()=ApiClient.instance.service.getCategory().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
}