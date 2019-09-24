package com.purnaprasanth.githubusers.appinitializers

import android.app.Application
import com.facebook.stetho.Stetho
import com.purnaprasanth.githubusers.BuildConfig
import com.purnaprasanth.githubusers.baseandroid.AppInitializer
import javax.inject.Inject

/**
 * Created by Purna on 2019-09-24 as a part of GithubUsers
 **/

/**
 * App Initializer for [Stetho]
 */

class StethoAppInitializer @Inject constructor() : AppInitializer {

    override fun init(application: Application) {
        if (BuildConfig.DEBUG) Stetho.initializeWithDefaults(application)
    }
}