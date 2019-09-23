package com.purnaprasanth.githubusers.baseandroid

import android.app.Application

/**
 * Created by Purna on 2019-09-23 as a part of GithubUsers
 **/

/**
 * Base Class For App Initializer
 */

interface AppInitializer {
    fun init(application: Application)
}