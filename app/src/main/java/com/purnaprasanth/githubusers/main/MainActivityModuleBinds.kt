package com.purnaprasanth.githubusers.main

import android.app.Activity
import android.content.Context
import dagger.Binds
import dagger.Module

/**
 * Created by Purna on 2019-09-24 as a part of GithubUsers
 **/

@Module
abstract class MainActivityModuleBinds {

    @Binds
    abstract fun provideActivityContext(activity: MainActivity): Context

    @Binds
    abstract fun provideActivity(activity: MainActivity): Activity
}