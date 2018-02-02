package com.pand.kotlin_eye.network

import android.content.Context
import android.widget.Toast
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 * @author： dwc
 * @date： 2018/2/1 15:58
 * @desc：
 */
abstract class RequestCallback<T>(private val context: Context) : Observer<ResponseWrapper<T>> {
    protected open fun success(data: ResponseWrapper<T>) {}
    abstract fun onFail(e: Throwable)
    protected open fun success(data: T) {}

    object status {
        val success = 1000
    }

    override fun onNext(t: ResponseWrapper<T>) {
        if (t.code == status.success) {
            if (t.data == null) {
                success(t)
            } else {
                success(t.data)
            }
        }
        Toast.makeText(context,"",Toast.LENGTH_SHORT)

    }

    override fun onComplete() {

    }

    override fun onSubscribe(d: Disposable) {

    }

    override fun onError(e: Throwable) {
        onFail(e)
    }
}