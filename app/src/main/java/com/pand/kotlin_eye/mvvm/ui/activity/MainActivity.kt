package com.pand.kotlin_eye.mvvm.ui.activity

import android.util.Log
import com.pand.kotlin_eye.R
import com.pand.kotlin_eye.base.BaseActivity
import com.pand.kotlin_eye.databinding.ActivityMainBinding
import com.pand.kotlin_eye.mvvm.viewmodel.BaseViewModel
import com.pand.kotlin_eye.network.*
import com.trello.rxlifecycle2.android.ActivityEvent
import com.trello.rxlifecycle2.android.FragmentEvent
import com.trello.rxlifecycle2.kotlin.bindUntilEvent

class MainActivity : BaseActivity<BaseViewModel, ActivityMainBinding>() ,IView{
    override fun setViewModel() {

    }

    override fun getViewModel(): BaseViewModel? {
        return null
    }

    override fun getLayoutRes(): Int = R.layout.activity_main


    override fun initData() {
        //bindToLifecycle()方法
        // 完成Observable发布的事件和当前的组件绑定，实现生命周期同步。从而实现当前组件生命周期结束时，自动取消对Observable订阅
        //bindUntilEvent() 方法
        //其中的CREATE、START、 RESUME、PAUSE、STOP、 DESTROY分别对应生命周期内的方法。使用bindUntilEvent指定在哪个生命周期方法调用时取消订阅。
        ApiClient.instance.service.updateVersion("1.5.0", 1)
                .compose(NetworkScheduler.compose())
                .compose(NetworkScheduler.bindToLifecycle(this))
                .subscribe(object : RequestCallback<VersionUpdate>(this) {
                     override fun success(data: VersionUpdate) {
                        Log.e(TAG, "-------success-->$data")
                    }
                    override fun onFail(e: Throwable) {
                        Log.e(TAG, "-------onFail-->")
                    }

                })

    }
}


