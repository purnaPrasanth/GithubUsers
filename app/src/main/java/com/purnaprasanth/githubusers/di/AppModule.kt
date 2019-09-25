package com.purnaprasanth.githubusers.di

import android.content.Context
import com.purnaprasanth.githubusers.annotation.App
import com.purnaprasanth.githubusers.base.util.MoshiUtils
import com.purnaprasanth.githubusers.baseandroid.SharedPrefManager
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Purna on 2019-09-24 as a part of GithubUsers
 **/

@Module(includes = [AppModuleBinds::class])
class AppModule {

    @Provides
    @Singleton
    fun provideMoshi() = Moshi.Builder().build()

    @Provides
    @Singleton
    fun provideMoshiUtils(moshi: Moshi) = MoshiUtils(moshi)

    @Provides
    @Singleton
    fun provideSharedPrefManager(@App context: Context, moshiUtils: MoshiUtils) = SharedPrefManager(moshiUtils, context)
}