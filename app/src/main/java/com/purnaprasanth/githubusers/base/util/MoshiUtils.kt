package com.purnaprasanth.githubusers.base.util

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import java.text.ParseException

/**
 * Created by Purna on 2019-09-25 as a part of GithubUsers
 **/

class MoshiUtils(
    val moshi: Moshi
) {

    fun <T : Any> serializeObject(cls: Class<T>, obj: T): String {
        val adapter = moshi.adapter(cls)
        return adapter.toJson(obj)
    }

    @Throws(ParseException::class)
    fun <T : Any> deseriaLizeObject(cls: Class<T>, data: String?): T? {
        if (data.isNullOrEmpty()) return null
        val adapter = moshi.adapter(cls)
        return adapter.fromJson(data)
    }

    fun <T : Any> serializeCollectionOfObjects(classType: Class<T>, data: List<T>): String {
        val type = Types.newParameterizedType(Collection::class.java, classType)
        val adapter: JsonAdapter<List<T>> = moshi.adapter(type)
        return adapter.toJson(data)
    }

    fun <T : Any> deSerializeCollectionOfObjects(classType: Class<T>, data: String?): List<T> {
        if (data.isNullOrEmpty()) return emptyList()
        val type = Types.newParameterizedType(Collection::class.java, classType)
        val adapter: JsonAdapter<List<T>> = moshi.adapter(type)
        return adapter.fromJson(data).orEmpty()
    }

}