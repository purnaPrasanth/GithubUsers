package com.purnaprasanth.githubusers.di

import android.app.Application
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.Gson
import com.purnaprasanth.githubusers.annotation.IO
import com.purnaprasanth.githubusers.base.AppDispatchers
import com.purnaprasanth.githubusers.github.IGitHubServices
import com.purnaprasanth.githubusers.github.okhttp.GitHubCoilDelegate
import com.purnaprasanth.githubusers.github.okhttp.OkHttpGitHubServices
import com.purnaprasanth.githubusers.github.okhttp.VersionInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.Dispatcher
import okhttp3.OkHttpClient
import java.util.concurrent.Executor
import java.util.concurrent.ExecutorService
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by Purna on 2019-09-24 as a part of GithubUsers
 **/

@Module(includes = [NetWorkModuleBinds::class])
class NetworkModule {

    @Provides
    @Singleton
    fun provideOkhttp(@IO ioExecutor: Executor, application: Application) = OkHttpClient.Builder()
        .dispatcher(Dispatcher(ioExecutor as ExecutorService))
        .connectTimeout(20, TimeUnit.SECONDS)
        .callTimeout(20, TimeUnit.SECONDS)
        .readTimeout(20, TimeUnit.SECONDS)
        .writeTimeout(20, TimeUnit.SECONDS)
        .addNetworkInterceptor(StethoInterceptor())
        .build()

    @Provides
    @Singleton
    fun provideCoilGithubDelegate(
        app: Application,
        okhttp: OkHttpClient,
        appDispatchers: AppDispatchers
    ) = GitHubCoilDelegate(app, okhttp, appDispatchers)

    @Provides
    @Singleton
    fun provideGitHubVersionInterceptor() = VersionInterceptor()

    @Provides
    @Singleton
    fun provideOkHttpGithubServices(
        okHttpClient: OkHttpClient,
        gson: Gson,
        versionInterceptor: VersionInterceptor
    ) = OkHttpGitHubServices(okHttpClient, gson, versionInterceptor)

    @Provides
    fun provideIGithubUserServices(githubServices: IGitHubServices) = githubServices.gitHubUserServices

    @Provides
    fun provideIGithubRepoServices(githubServices: IGitHubServices) = githubServices.gitHubRepoServices
}