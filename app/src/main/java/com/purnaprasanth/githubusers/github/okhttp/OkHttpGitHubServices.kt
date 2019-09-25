package com.purnaprasanth.githubusers.github.okhttp

import com.purnaprasanth.githubusers.github.IGitHubServices
import com.purnaprasanth.githubusers.github.dataservices.IGitHubRepoServices
import com.purnaprasanth.githubusers.github.dataservices.IGitHubUserServices
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Created by Purna on 2019-09-23 as a part of GithubUsers
 **/

/**
 * An Implementation of [IGitHubServices] that generates services using [OkHttpClient] and [Retrofit]
 */

class OkHttpGitHubServices(
    okHttpClient: OkHttpClient,
    versionInterceptor: VersionInterceptor,
    moshi: Moshi
) : IGitHubServices {

    private val githubOkHttpClient: OkHttpClient = okHttpClient
        .newBuilder()
        .addInterceptor(versionInterceptor)
        .build()

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com")
        .client(githubOkHttpClient)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    override val gitHubUserServices: IGitHubUserServices by lazy {
        retrofit.create(IGitHubUserServices::class.java)
    }

    override val gitHubRepoServices: IGitHubRepoServices by lazy {
        retrofit.create(IGitHubRepoServices::class.java)
    }
}