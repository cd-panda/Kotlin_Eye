package com.pand.kotlin_eye.network

/**
 * @author： dwc
 * @date： 2018/2/1 16:53
 * @desc：
 */
class VersionUpdate(var version: String?, var force: Boolean, var forceNotice: Boolean, var platform: Int, var url: String?, var description: String?, var valid: Boolean) {
    override fun toString(): String {
        return "VersionUpdate(version=$version, force=$force, forceNotice=$forceNotice, platform=$platform, url=$url, description=$description, valid=$valid)"
    }
}