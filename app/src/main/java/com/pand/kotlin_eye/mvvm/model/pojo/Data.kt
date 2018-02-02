package com.pand.kotlin_eye.mvvm.model.pojo

/**
 * Created by 李培生 on 2018/2/2 10:01.
 * gankio的返回数据
 */

data class GankIoData(var isError: Boolean, var results: List<ResultsBean>)
data class ResultsBean( var _id: String, var createdAt: String, var desc: String, var publishedAt: String, var source: String, var type: String, var url: String, var isUsed: Boolean, var who: String)
data class VersionUpdate(var version: String?, var force: Boolean, var forceNotice: Boolean, var platform: Int, var url: String?, var description: String?, var valid: Boolean)