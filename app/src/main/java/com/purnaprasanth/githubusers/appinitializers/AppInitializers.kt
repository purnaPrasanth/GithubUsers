package com.purnaprasanth.githubusers.appinitializers

import android.app.Application
import com.purnaprasanth.githubusers.baseandroid.AppInitializer
import javax.inject.Inject

/**
 * Created by Purna on 2019-09-24 as a part of GithubUsers
 **/

/**
 * Single place for initializing all [AppInitializer]
 */

class AppInitializers @Inject constructor(
    private val initializers: Set<@JvmSuppressWildcards AppInitializer>
) {
    fun init(application: Application) {
        initializers.forEach {
            it.init(application)
        }
    }
}