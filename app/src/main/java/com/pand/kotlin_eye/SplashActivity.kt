package com.pand.kotlin_eye

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.databinding.ViewDataBinding
import com.pand.kotlin_eye.base.BaseActivity
import com.pand.kotlin_eye.mvvm.viewmodel.BaseViewModel
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : BaseActivity<BaseViewModel,ViewDataBinding>() {
    override fun setViewModel() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    
    override fun getViewModel(): BaseViewModel {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    
    override fun getLayoutRes() = R.layout.activity_splash
    
    override fun initData() {
//        Observable.timer(2,TimeUnit.SECONDS).subscribe({toMain()})
        var aniX = ObjectAnimator.ofFloat(img, "scaleX", 1f, 1.3f)
        var aniY = ObjectAnimator.ofFloat(img, "scaleY", 1f, 1.3f)
        AnimatorSet().run {
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
    }
    
    private fun toMain() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
    
    
}
