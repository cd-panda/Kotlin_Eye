package com.pand.kotlin_eye

import com.pand.kotlin_eye.base.BaseActivity
import com.pand.kotlin_eye.databinding.ActivityMainBinding
import com.pand.kotlin_eye.mvvm.viewmodel.BaseViewModel

class MainActivity : BaseActivity<BaseViewModel,ActivityMainBinding>() {
    override fun setViewModel() {

    }
    
    override fun getViewModel(): BaseViewModel? {
       return null
    }
    
    override fun getLayoutRes(): Int =R.layout.activity_main
    override fun initData() {

    }
    
    
}
