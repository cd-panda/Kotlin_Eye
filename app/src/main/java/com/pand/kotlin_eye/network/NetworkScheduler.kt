package com.pand.kotlin_eye.network

import com.pand.kotlin_eye.mvvm.contract.IView
import com.trello.rxlifecycle2.LifecycleTransformer
import com.trello.rxlifecycle2.android.ActivityEvent
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity
import com.trello.rxlifecycle2.components.support.RxFragment
import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * @author： dwc
 * @date： 2018/2/1 16:59
 * @desc：
 */
object NetworkScheduler {
    fun <T> compose(): ObservableTransformer<T, T> {
        return ObservableTransformer { upstream ->
            upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
        }
    }

    fun <T> bindToLifecycle(view: IView): LifecycleTransformer<T> {
        return when (view) {
            is RxAppCompatActivity -> (view as RxAppCompatActivity).bindUntilEvent(ActivityEvent.DESTROY)
            is RxFragment -> (view as RxFragment).bindToLifecycle()
            else -> throw IllegalArgumentException("view isn't activity or fragment")
        }

    }
}