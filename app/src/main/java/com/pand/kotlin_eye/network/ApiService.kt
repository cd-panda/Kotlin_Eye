package com.pand.kotlin_eye.network

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author： dwc
 * @date： 2018/2/1 14:48
 * @desc：
 */
interface ApiService {
    //版本更新接口
    @GET("app/version")
    fun updateVersion(@Query("version") version: String, @Query("platform") platform: Int): Observable<ResponseWrapper<VersionUpdate>>

}