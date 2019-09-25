package com.purnaprasanth.githubusers.main

import dagger.Subcomponent
import dagger.android.AndroidInjector

/**
 * Created by Purna on 2019-09-24 as a part of GithubUsers
 **/

@Subcomponent(modules = [MainActivityModule::class])
interface MainActivityComponent : AndroidInjector<MainActivity> {
    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<MainActivity>
}