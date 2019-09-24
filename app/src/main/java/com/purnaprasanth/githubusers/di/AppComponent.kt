package com.purnaprasanth.githubusers.di

import com.purnaprasanth.githubusers.GithubUserApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

/**
 * Created by Purna on 2019-09-24 as a part of GithubUsers
 **/

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        NetworkModule::class,
        ExecutorModule::class,
        ViewModelModule::class,
        ActivityModule::class
    ]
)
interface AppComponent : AndroidInjector<GithubUserApplication> {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: GithubUserApplication): AppComponent
    }
}