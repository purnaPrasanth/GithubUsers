package com.purnaprasanth.githubusers.di

import com.purnaprasanth.githubusers.annotation.Common
import com.purnaprasanth.githubusers.annotation.IO
import com.purnaprasanth.githubusers.annotation.Main
import com.purnaprasanth.githubusers.async.CommonExecutor
import com.purnaprasanth.githubusers.async.IOExecutor
import com.purnaprasanth.githubusers.async.MainThreadExecutor
import com.purnaprasanth.githubusers.base.AppDispatchers
import com.purnaprasanth.githubusers.base.AppExecutors
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.asCoroutineDispatcher
import javax.inject.Singleton

/**
 * Created by Purna on 2019-09-24 as a part of GithubUsers
 **/

@Module
class ExecutorModule {

    @Provides
    @Singleton
    fun provideAppExecutors(
        mainExecutor: MainThreadExecutor,
        ioExecutor: IOExecutor,
        commonExecutor: CommonExecutor
    ): AppExecutors {
        return AppExecutors(
            mainExecutor = mainExecutor.executor,
            ioExecutor = ioExecutor.executor,
            commonExecutor = commonExecutor.executor
        )
    }

    @Provides
    @Singleton
    fun provideAppDispatchers(appExecutors: AppExecutors): AppDispatchers {
        return AppDispatchers(
            mainDispatcher = appExecutors.mainExecutor.asCoroutineDispatcher(),
            ioDispatcher = appExecutors.ioExecutor.asCoroutineDispatcher(),
            commonDispatcher = appExecutors.commonExecutor.asCoroutineDispatcher()
        )
    }

    @Provides
    @IO
    fun provideIODispatcher(appDispatchers: AppDispatchers) = appDispatchers.ioDispatcher

    @Provides
    @Common
    fun provideCommonDispatcher(appDispatchers: AppDispatchers) = appDispatchers.commonDispatcher

    @Provides
    @Main
    fun provideMainDispatcher(appDispatchers: AppDispatchers) = appDispatchers.mainDispatcher

    @Provides
    @IO
    fun provideIOExecutor(appExecutors: AppExecutors) = appExecutors.ioExecutor

    @Provides
    @Common
    fun provideCommonExecutor(appExecutors: AppExecutors) = appExecutors.commonExecutor

    @Provides
    @Main
    fun provideMainExecutor(appExecutors: AppExecutors) = appExecutors.mainExecutor
}