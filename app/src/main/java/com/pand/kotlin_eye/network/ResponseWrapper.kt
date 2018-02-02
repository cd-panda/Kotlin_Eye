package com.pand.kotlin_eye.network

/**
 * @author： dwc
 * @date： 2018/2/1 16:05
 * @desc：
 */
data class ResponseWrapper<T>(var code: Int, var message: String, var data: T) {
    override fun toString(): String {
        return "ResponseWrapper(code=$code, message='$message', data=$data)"
    }
}
