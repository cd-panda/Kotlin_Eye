package com.pand.kotlin_eye.mvvm.ui.activity

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.pand.kotlin_eye.R
import com.pand.kotlin_eye.base.BaseActivity
import com.pand.kotlin_eye.databinding.ActivityVideoPlayBinding
import com.pand.kotlin_eye.mvvm.contract.VideoPlayContract
import com.pand.kotlin_eye.mvvm.viewmodel.VideoPlayViewModel
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer

class VideoPlayActivity : BaseActivity<VideoPlayViewModel, ActivityVideoPlayBinding>(), VideoPlayContract.IVideoPlayView {
    companion object {
        /*Intent跳转的常量*/
        const val INTENT_VIDEOURL = "video_url"
        const val INTENT_VIDEOCONVER = "video_conver"
    }
    
    lateinit var videourl: String
    /*封面*/
    lateinit var videoconver: String
    /*播放器组件*/
    var videoPlayer: StandardGSYVideoPlayer? = null
    
    override fun initVideoPlayerConfig() {
        videoPlayer = mBinding?.videoView
//    封面
        val imageView = ImageView(this)
        imageView.scaleType = ImageView.ScaleType.FIT_XY
        Glide.with(this).load(videoconver).into(imageView)
        videoPlayer?.thumbImageView = imageView
        /*加载播放*/
        videoPlayer?.setUp(videourl, true, "test")
    }
    
    override fun setViewModel() {
    
    }
    
    override fun getViewModel(): VideoPlayViewModel? = VideoPlayViewModel()
    
    override fun getLayoutRes() = R.layout.activity_video_play
    
    override fun initData() {
        getIntentData()
        initVideoPlayerConfig()
    }
    
    /**
     * 接收Intent传递的数据
     */
    private fun getIntentData() {
        videourl = intent.getStringExtra(INTENT_VIDEOURL)
        videoconver = intent.getStringExtra(INTENT_VIDEOCONVER)
    }
    
    
    override fun onResume() {
        super.onResume()
        videoPlayer?.onVideoResume()
    }
    
    override fun onPause() {
        super.onPause()
        videoPlayer?.onVideoPause()
    }

}
