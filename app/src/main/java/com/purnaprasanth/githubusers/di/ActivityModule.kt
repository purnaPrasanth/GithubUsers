package com.purnaprasanth.githubusers.di

import com.purnaprasanth.githubusers.main.MainActivity
import com.purnaprasanth.githubusers.main.MainActivityComponent
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

/**
 * Created by Purna on 2019-09-24 as a part of GithubUsers
 **/

@Module(subcomponents = [MainActivityComponent::class])
abstract class ActivityModule {

    @Binds
    @IntoMap
    @ClassKey(MainActivity::class)
    internal abstract fun bindMainActivity(factory: MainActivityComponent.Factory): AndroidInjector.Factory<*>
}