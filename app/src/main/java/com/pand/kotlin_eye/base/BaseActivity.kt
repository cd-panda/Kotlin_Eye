package com.pand.kotlin_eye.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.pand.kotlin_eye.mvvm.viewmodel.BaseViewModel
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity

/**
 * Created by 李培生 on 2018/1/31 14:22
 */
abstract class BaseActivity<T : BaseViewModel, D : ViewDataBinding> : RxAppCompatActivity() {
    var mViewModel: T? = null
    var mBinding: D? = null
    val TAG = this::class.java.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initDataBinding()
        initData()
    }

    private fun initDataBinding() {
        mBinding = DataBindingUtil.setContentView(this, getLayoutRes())
        mViewModel = getViewModel()
        setViewModel()
    }

    abstract fun setViewModel()

    abstract fun getViewModel(): T?

    /**
     * Activity 提供布局文件
     */
    abstract fun getLayoutRes(): Int

    /**
     * 加载数据
     */
    abstract fun initData()
}
