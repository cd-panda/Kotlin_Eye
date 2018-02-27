package com.pand.kotlin_eye.mvvm.ui.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import com.pand.kotlin_eye.R
import com.pand.kotlin_eye.base.BaseFragment
import com.pand.kotlin_eye.base.adapter.HomePageAdapter
import com.pand.kotlin_eye.databinding.FragmentMainBinding
import com.pand.kotlin_eye.mvvm.contract.HomePageContract
import com.pand.kotlin_eye.mvvm.model.pojo.HomeBean
import com.pand.kotlin_eye.mvvm.viewmodel.HomePageViewModel


/**
 * A simple [Fragment] subclass.
 */
class MainFragment : BaseFragment<HomePageViewModel, FragmentMainBinding>(),HomePageContract.View{
    override fun refresData(testdata: HomeBean): Unit {
        homePageAdapter?.setHomePageData(testdata.issueList[0].itemList)
        homePageAdapter?.notifyDataSetChanged()
    }
    
    var homePageAdapter: HomePageAdapter? = null
    
    override fun setViewModel() {
    }
    
    override fun getViewModel(): HomePageViewModel = HomePageViewModel(this)
    
    override fun getLayoutRes(): Int = R.layout.fragment_main
    
    override fun initView() {
        homePageAdapter = HomePageAdapter(activity)
        mBinding.recyclerview.layoutManager = LinearLayoutManager(activity)
        mBinding.recyclerview.adapter = homePageAdapter
    }
    
    
    companion object {
        private val ARG_PARAM1 = "param1"
        private val ARG_PARAM2 = "param2"
        fun newInstance(param1: String, param2: String): MainFragment {
            val fragment = MainFragment()
            val args = Bundle()
            args.putString(ARG_PARAM1, param1)
            args.putString(ARG_PARAM2, param2)
            fragment.arguments = args
            return fragment
        }
    }
}
