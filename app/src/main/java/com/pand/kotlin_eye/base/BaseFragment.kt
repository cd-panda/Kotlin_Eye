package com.pand.kotlin_eye.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by 李培生 on 2018/1/31 18:06.
 */
abstract class BaseFragment : Fragment() {
    val TAG=this::class.java.simpleName
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? = inflater?.inflate(getLayoutRes(), container)
    abstract fun getLayoutRes(): Int
}