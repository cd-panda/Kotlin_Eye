package com.pand.kotlin_eye

import com.pand.kotlin_eye.base.BaseActivity
import com.pand.kotlin_eye.databinding.ActivityMainBinding
import com.pand.kotlin_eye.mvvm.viewmodel.BaseViewModel

class MainActivity : BaseActivity<BaseViewModel,ActivityMainBinding>() {
    override fun setViewModel() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    
    override fun getViewModel(): BaseViewModel {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    
    override fun getLayoutRes(): Int =R.layout.activity_main
    override fun initData() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    
    
}
