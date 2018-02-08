package com.pand.kotlin_eye.mvvm.ui.activity

import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.view.MenuItem
import com.pand.kotlin_eye.R
import com.pand.kotlin_eye.base.BaseActivity
import com.pand.kotlin_eye.databinding.ActivityMainBinding
import com.pand.kotlin_eye.mvvm.contract.IView
import com.pand.kotlin_eye.mvvm.ui.fragment.CategoryFragment
import com.pand.kotlin_eye.mvvm.ui.fragment.HotFragment
import com.pand.kotlin_eye.mvvm.ui.fragment.MainFragment
import com.pand.kotlin_eye.mvvm.ui.fragment.MineFragment
import com.pand.kotlin_eye.mvvm.viewmodel.BaseViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<BaseViewModel, ActivityMainBinding>(), IView {
    lateinit var fragments: List<Fragment>
    private var lastShowFragment = 0

    override fun setViewModel() {

    }

    override fun getViewModel(): BaseViewModel? {
        return null
    }

    override fun getLayoutRes(): Int = R.layout.activity_main


    override fun initData() {
        /*  //bindToLifecycle()方法
          // 完成Observable发布的事件和当前的组件绑定，实现生命周期同步。从而实现当前组件生命周期结束时，自动取消对Observable订阅
          //bindUntilEvent() 方法
          //其中的CREATE、START、 RESUME、PAUSE、STOP、 DESTROY分别对应生命周期内的方法。使用bindUntilEvent指定在哪个生命周期方法调用时取消订阅。
          ApiClient.instance.updateVersion(this, object :RequestCallback<VersionUpdate>(this){
              override fun onSuccess(data: VersionUpdate) {
              }
              override fun onFail(e: Throwable) {

              }

          })*/
        initFragments()
        navigation.setOnNavigationItemSelectedListener(object : BottomNavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when (item.itemId) {
                    R.id.home -> if (lastShowFragment != 0) {
                        switchFragment(lastShowFragment, 0)
                        lastShowFragment = 0
                    }
                    R.id.category -> if (lastShowFragment != 1) {
                        switchFragment(lastShowFragment, 1)
                        lastShowFragment = 1
                    }
                    R.id.hot -> if (lastShowFragment != 2) {
                        switchFragment(lastShowFragment, 2)
                        lastShowFragment = 2
                    }

                    R.id.mine -> if (lastShowFragment != 3) {
                        switchFragment(lastShowFragment, 3)
                        lastShowFragment = 3
                    }
                }
                return true
            }

        })
    }

    fun switchFragment(lastIndex: Int, index: Int) {
        val beginTransaction = supportFragmentManager.beginTransaction()
        beginTransaction.hide(fragments[lastIndex])
        if (!fragments[index].isAdded) {
            beginTransaction.add(R.id.frame, fragments[index])
        }
        beginTransaction.show(fragments[index]).commitAllowingStateLoss()
    }

    private fun initFragments() {
        val one = MainFragment()
        val one2 = CategoryFragment()
        val one3 = HotFragment()
        val one4 = MineFragment()
        fragments = listOf(one, one2, one3, one4)
        supportFragmentManager
                .beginTransaction()
                .add(R.id.frame, one)
                .show(one)
                .commit()
    }
}



