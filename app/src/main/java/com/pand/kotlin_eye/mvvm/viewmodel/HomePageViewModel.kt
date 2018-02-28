package com.pand.kotlin_eye.mvvm.viewmodel

import android.util.Log
import com.pand.kotlin_eye.mvvm.contract.HomePageContract
import com.pand.kotlin_eye.mvvm.model.HomePageModel
import com.pand.kotlin_eye.mvvm.model.pojo.HomeBean
import com.pand.kotlin_eye.mvvm.ui.fragment.MainFragment

/**
 * Created by 李培生 on 2018/2/26 15:34.
 */
class HomePageViewModel(val view: MainFragment) : BaseViewModel(), HomePageContract.ViewModel {
    /*存储下一页的地址*/
    var nextPageUrl: String? = null
    var homePageModel: HomePageModel? = null
    var dataList: ArrayList<HomeBean.Issue.Item> = ArrayList()
    
    init {
        loadFirstData()
    }
    
    /**
     * 加载banner和第一页的数据
     */
    fun loadFirstData() {
        dataList.clear()
        homePageModel = HomePageModel().apply {
            requestData(1)
                    .subscribe({ it ->
                        view.setBannerData(it.issueList[0].itemList)
                        view.refreshEnd()
                        nextPageUrl = it.nextPageUrl
                        loadMoreData()
                    }, { t -> Log.e(TAG, t.message) })
        }
    }
    
    /**
     * 加载更多的数据
     */
    override fun loadMoreData() {
        homePageModel?.loadMoreData(nextPageUrl)?.subscribe({ it ->
            dataList.addAll(it.issueList[0].itemList)
            view.refresData(dataList)
            nextPageUrl = it.nextPageUrl
            view.loadMoreEnd()
        })
    }
}
