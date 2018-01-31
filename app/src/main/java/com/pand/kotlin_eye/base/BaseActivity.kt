package com.pand.kotlin_eye.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
* Created by 李培生 on 2018/1/31 14:22
*/
open abstract class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutRes())
        initData()
    }
    
    /**
     * Activity 提供布局文件
     */
    abstract fun getLayoutRes(): Int
    
    /**
     * 加载数据
     */
    abstract fun initData()
}
