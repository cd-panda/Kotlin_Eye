package com.pand.kotlin_eye

import android.app.Application
import com.pand.kotlin_eye.network.ApiClient

/**
 * @author： dwc
 * @date： 2018/2/1 17:11
 * @desc：
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        ApiClient.instance.init()
    }
}