package com.pand.kotlin_eye.network

import com.pand.kotlin_eye.mvvm.model.pojo.GankIoData
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.*

/**
 * @author： dwc
 * @date： 2018/2/1 14:48
 * @desc：
 */
interface ApiService {
    //版本更新接口
    @GET("app/version")
    fun updateVersion(@Query("version") version: String, @Query("platform") platform: Int): Observable<ResponseWrapper<VersionUpdate>>

    @GET("http://gank.io/api/data/福利/{mon}/{day}")
    fun getSplash(@Path("mon") mon: Int,@Path("day") day: Int):Observable<GankIoData>
}