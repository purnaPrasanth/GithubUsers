package com.purnaprasanth.githubusers.github.okhttp

import com.google.gson.Gson
import com.purnaprasanth.githubusers.github.IGitHubServices
import com.purnaprasanth.githubusers.github.dataservices.IGitHubRepoServices
import com.purnaprasanth.githubusers.github.dataservices.IGitHubUserServices
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Purna on 2019-09-23 as a part of GithubUsers
 **/

/**
 * An Implementation of [IGitHubServices] that generates services using [OkHttpClient] and [Retrofit]
 */

internal class OkHttpGitHubServices(
    okHttpClient: OkHttpClient,
    gson: Gson,
    versionInterceptor: VersionInterceptor
) : IGitHubServices {

    private val githubOkHttpClient: OkHttpClient = okHttpClient
        .newBuilder()
        .addInterceptor(versionInterceptor)
        .build()

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(githubOkHttpClient)
        .build()

    override val gitHubUserServices: IGitHubUserServices by lazy {
        retrofit.create(IGitHubUserServices::class.java)
    }

    override val gitHubRepoServices: IGitHubRepoServices by lazy {
        retrofit.create(IGitHubRepoServices::class.java)
    }
}