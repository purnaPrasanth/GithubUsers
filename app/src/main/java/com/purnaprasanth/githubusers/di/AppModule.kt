package com.purnaprasanth.githubusers.di

import com.google.gson.Gson
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
    fun provideGSon() = Gson()
}