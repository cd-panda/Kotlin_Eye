package com.pand.kotlin_eye.base.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import cn.bingoogolapple.bgabanner.BGABanner
import com.bumptech.glide.Glide
import com.pand.kotlin_eye.R
import com.pand.kotlin_eye.mvvm.model.pojo.HomeBean
import com.pand.kotlin_eye.mvvm.ui.activity.VideoPlayActivity
import io.reactivex.Observable

/**
 * Created by 李培生 on 2018/2/26 16:15.
 */
class HomePageAdapter(val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    val TAG = this::class.java.simpleName
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) =
            when (getItemViewType(position)) {
                /*banner类型的处理*/
                TYPE_BANNER -> {
                    /*这里不确定有多少个。先取1.。4*/
                    val bannerData: ArrayList<HomeBean.Issue.Item>? = homebannerdata?.slice(1..4)?.toCollection(ArrayList())
                    val bannerFeedList: ArrayList<String> = ArrayList()
                    val bannerTitleList: ArrayList<String> = ArrayList()
                    Observable.fromIterable(bannerData).subscribe({ list ->
                        bannerFeedList.add(list.data?.cover?.feed ?: "")
                        bannerTitleList.add(list.data?.title ?: "")
                    })
                    
                    val bannerHolder = holder as BannerHolder
                    bannerHolder.banner.run {
                        setAutoPlayAble(bannerFeedList.size > 0)
                        setData(bannerFeedList, bannerTitleList)
                        setAdapter(object : BGABanner.Adapter<ImageView, String> {
                            override fun fillBannerItem(bgaBanner: BGABanner?, imageview: ImageView?, feedurl: String?, position: Int) {
                               Log.e(TAG,"$feedurl+$position")
                                Glide.with(context)
                                        .load(feedurl)
                                        .placeholder(R.drawable.placeholder_banner)
                                        .into(imageview)
                            }
                        })
                    }
                    
                }
                /*正常item的类型处理*/
                else -> {
                    val holder:ItemHHolder =holder as ItemHHolder
                    Log.d(TAG,data?.get(position).toString())
                    Glide.with(context).load(data?.get(position)?.data?.cover?.feed).into(holder.conver)
                    holder.conver.setOnClickListener({
                     var intent=   Intent(context,VideoPlayActivity::class.java)
                        intent.putExtra(VideoPlayActivity.INTENT_VIDEOURL,data?.get(position)?.data?.playUrl)
                        intent.putExtra(VideoPlayActivity.INTENT_VIDEOCONVER,data?.get(position)?.data?.cover?.feed)
                        context.startActivity(intent)
                    })
                }
            }
    
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        /*根据不同类型引入不同布局*/
        return when (viewType) {
            TYPE_BANNER -> BannerHolder(LayoutInflater.from(parent?.context).inflate(R.layout.home_banner, null))
            else -> ItemHHolder(LayoutInflater.from(parent?.context).inflate(R.layout.item_homepage, null))
        }
    }
    
    override fun getItemCount(): Int {
        return data?.size ?: 0
    }
    
    /*多布局类型*/
     val TYPE_BANNER = 0
     val TYPE_ITEM = 1
    var data: ArrayList<HomeBean.Issue.Item>? = null
    var homebannerdata: ArrayList<HomeBean.Issue.Item>? = null
    
    
    override fun getItemViewType(position: Int): Int {
        return when (position) {
        /*第一项为banner，其他为内容*/
            0 -> TYPE_BANNER
            else -> TYPE_ITEM
        }
    }
    
    /**
     * 更新主页列表的数据
     */
    fun setHomePageData(testdata: ArrayList<HomeBean.Issue.Item>) {
        data = testdata
        notifyDataSetChanged()
    }
    
    /**
     * 更新banner的数据
     */
    fun setHomeBanner(banner: ArrayList<HomeBean.Issue.Item>) {
        homebannerdata = banner
        notifyDataSetChanged()
    }
    
    
    class BannerHolder(inflate: View) : RecyclerView.ViewHolder(inflate) {
        val banner: BGABanner = inflate.findViewById(R.id.banner)
    }
    
    class ItemHHolder(inflate: View) : RecyclerView.ViewHolder(inflate) {
    val conver:ImageView=inflate.findViewById(R.id.conver)
    }
}

