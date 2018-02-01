package com.pand.kotlin_eye.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pand.kotlin_eye.mvvm.viewmodel.BaseViewModel

/**
 * Created by 李培生 on 2018/1/31 18:06.
 */
abstract class BaseFragment<T : BaseViewModel, D : ViewDataBinding> : Fragment() {
    val TAG = this::class.java.simpleName
    lateinit var mViewModel: T
    lateinit var mBinding: D
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = DataBindingUtil.inflate(inflater, getLayoutRes(), container, false)
        getViewModel()
        setViewModel()
        return mBinding.root
    }
    
    abstract fun setViewModel()
    
    abstract fun getViewModel()
    
    abstract fun getLayoutRes(): Int
}