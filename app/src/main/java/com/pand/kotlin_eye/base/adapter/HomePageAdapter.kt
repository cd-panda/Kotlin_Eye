package com.pand.kotlin_eye.base.adapter

import android.content.Context
import com.pand.kotlin_eye.R

/**
 * Created by 李培生 on 2018/2/26 16:15.
 */
class HomePageAdapter(context: Context): MultiTypeAdapter(context) {
    public val TYPE_BANNER=0
  public  val TYPE_ITEM=1
    init {
        addViewTypeToLayoutMap(TYPE_BANNER, R.layout.home_banner)
        addViewTypeToLayoutMap(TYPE_ITEM,R.layout.item_homepage)
    }
    
}

