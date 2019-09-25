package com.purnaprasanth.githubusers.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.purnaprasanth.githubusers.annotation.ViewModelKey
import com.purnaprasanth.githubusers.baseandroid.ViewModelFactory
import com.purnaprasanth.githubusers.main.SearchUserVM
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by Purna on 2019-09-24 as a part of GithubUsers
 **/

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(SearchUserVM::class)
    internal abstract fun provideTrendingReposVM(viewModel: SearchUserVM): ViewModel

}