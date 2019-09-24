package com.purnaprasanth.githubusers.di

import android.app.Application
import android.content.Context
import com.purnaprasanth.githubusers.GithubUserApplication
import com.purnaprasanth.githubusers.annotation.App
import com.purnaprasanth.githubusers.appinitializers.StethoAppInitializer
import com.purnaprasanth.githubusers.baseandroid.AppInitializer
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoSet

/**
 * Created by Purna on 2019-09-24 as a part of GithubUsers
 **/

@Module
abstract class AppModuleBinds {
    @Binds
    @App
    abstract fun bindApplicationContext(application: GithubUserApplication): Context

    @Binds
    abstract fun bindApplication(application: GithubUserApplication): Application

    @Binds
    @IntoSet
    abstract fun provideStethoInitializer(stethoAppInitializer: StethoAppInitializer): AppInitializer
}