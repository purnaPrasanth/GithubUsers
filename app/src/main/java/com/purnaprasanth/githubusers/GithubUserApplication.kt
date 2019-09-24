package com.purnaprasanth.githubusers

import com.purnaprasanth.githubusers.appinitializers.AppInitializers
import com.purnaprasanth.githubusers.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import javax.inject.Inject

/**
 * Created by Purna on 2019-09-23 as a part of GithubUsers
 **/

class GithubUserApplication : DaggerApplication() {

    @Inject
    lateinit var initializers: AppInitializers

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.factory().create(this)
    }

}