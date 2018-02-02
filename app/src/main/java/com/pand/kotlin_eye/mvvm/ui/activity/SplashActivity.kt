package com.pand.kotlin_eye.mvvm.ui.activity

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.databinding.ViewDataBinding
import android.util.Log
import com.bumptech.glide.Glide
import com.pand.kotlin_eye.R
import com.pand.kotlin_eye.base.BaseActivity
import com.pand.kotlin_eye.mvvm.contract.SplashContract
import com.pand.kotlin_eye.mvvm.viewmodel.SplashViewModel
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : BaseActivity<SplashViewModel, ViewDataBinding>(), SplashContract.View {
    
    override fun loadImg(url: String?) {
        Glide.with(this).load(url).into(img)
    }
    
    override fun setViewModel() {}
    
    override fun getViewModel(): SplashViewModel? = SplashViewModel(this)
    
    override fun getLayoutRes() = R.layout.activity_splash
    
    override fun initData() {
        mViewModel?.loadImage()
//        Observable.timer(2,TimeUnit.SECONDS).subscribe({toMain()})
        var aniX = ObjectAnimator.ofFloat(img, "scaleX", 1f, 1.3f)
        var aniY = ObjectAnimator.ofFloat(img, "scaleY", 1f, 1.3f)
        val animation = AnimatorSet().apply {
            duration = 2000
            playTogether(aniX, aniY)
            /*object 为匿名对象
            *参见https://www.kotlincn.net/docs/reference/object-declarations.html
            * */
            addListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator?) {
                    toMain()
                }
            })
            start()
        }
        /*如果不想等待动画结束。点击跳转
        * 本来想调用animation的cancle，但是还是会走end回调。所以就用removeAllListeners方式了
        * */
        img.setOnClickListener {
            animation.removeAllListeners()
            toMain()
        }
    }
    
    /**
     * 跳转到主界面
     */
    private fun toMain() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}
