package com.pand.kotlin_eye.network

import android.util.Log
import com.pand.kotlin_eye.mvvm.model.pojo.VersionUpdate
import io.reactivex.Observable
import io.reactivex.Observer
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


/**
 * @author： dwc
 * @date： 2018/2/1 14:51
 * @desc：
 */
class ApiClient private constructor() {
    lateinit var service: ApiService
    val DEFAULT_TIMEOUT = 30L

    companion object {
        val instance by lazy { ApiClient() }
    }

    fun init() {
        val newBuilder = OkHttpClient().newBuilder()
        val okHttpClient = newBuilder.addInterceptor { chain ->
            val newBuilder1 = chain.request()?.newBuilder()
            //添加head
            val build = newBuilder1?.build()
            chain.proceed(build)
        }.addInterceptor(HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { message ->
            Log.e("TAG", "---->$message")
        }).setLevel(HttpLoggingInterceptor.Level.BODY)).build()
        newBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS).readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
        val retrofit = Retrofit.Builder()
                .baseUrl("http://192.168.0.86:8079/dispatcher/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build()

        service = retrofit.create(ApiService::class.java)
    }

    fun updateVersion(view: IView, callback: RequestCallback<VersionUpdate>) {
        val updateVersion = ApiClient.instance.service.updateVersion("1.5.0", 1)
        toSubscribe(view, updateVersion, callback)
    }

    private fun <T : Any?> toSubscribe(view: IView, o: Observable<T>, s: Observer<T>) {
        o.compose(NetworkScheduler.compose())
                .compose(NetworkScheduler.bindToLifecycle(view))
                .subscribe(s)
    }


}