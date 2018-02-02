package com.pand.kotlin_eye.mvvm.model.pojo

/**
 * Created by 李培生 on 2018/2/2 10:01.
 */

class GankIoData {

    /**
     * error : false
     * results : [{"_id":"5a6e5f88421aa9115696004f","createdAt":"2018-01-29T07:40:56.269Z","desc":"1-29","publishedAt":"2018-01-29T07:53:57.676Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/20180129074038_O3ydq4_Screenshot.jpeg","used":true,"who":"daimajia"},{"_id":"5a65381a421aa91156960022","createdAt":"2018-01-22T09:02:18.715Z","desc":"1-22","publishedAt":"2018-01-23T08:46:45.132Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/20180122090204_A4hNiG_Screenshot.jpeg","used":true,"who":"daimajia"}]
     */

    var isError: Boolean = false
    var results: List<ResultsBean>? = null

    class ResultsBean {
        /**
         * _id : 5a6e5f88421aa9115696004f
         * createdAt : 2018-01-29T07:40:56.269Z
         * desc : 1-29
         * publishedAt : 2018-01-29T07:53:57.676Z
         * source : chrome
         * type : 福利
         * url : http://7xi8d6.com1.z0.glb.clouddn.com/20180129074038_O3ydq4_Screenshot.jpeg
         * used : true
         * who : daimajia
         */

        var _id: String? = null
        var createdAt: String? = null
        var desc: String? = null
        var publishedAt: String? = null
        var source: String? = null
        var type: String? = null
        var url: String? = null
        var isUsed: Boolean = false
        var who: String? = null
    }
}
