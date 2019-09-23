package com.purnaprasanth.githubusers.github.okhttp

import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by Purna on 2019-09-23 as a part of GithubUsers
 **/

/**
 * Interceptor to use v3 version of the Github API
 */

class VersionInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()

        val newRequest = requestBuilder.apply {
            addHeader("Accept", "application/vnd.github.v3+json")
        }.build()

        return chain.proceed(newRequest)
    }
}