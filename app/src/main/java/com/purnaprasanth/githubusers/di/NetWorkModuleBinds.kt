package com.purnaprasanth.githubusers.di

import coil.ImageLoader
import com.purnaprasanth.githubusers.annotation.GitHub
import com.purnaprasanth.githubusers.data.datasources.GitHubUserDataSource
import com.purnaprasanth.githubusers.data.datasources.IGitUserDataSource
import com.purnaprasanth.githubusers.github.IGitHubServices
import com.purnaprasanth.githubusers.github.okhttp.GitHubCoilDelegate
import com.purnaprasanth.githubusers.github.okhttp.OkHttpGitHubServices
import dagger.Binds
import dagger.Module

/**
 * Created by Purna on 2019-09-24 as a part of GithubUsers
 **/

@Module
abstract class NetWorkModuleBinds {
    @Binds
    @GitHub
    abstract fun bindGithubServices(okhttpService: OkHttpGitHubServices): IGitHubServices

    @Binds
    @GitHub
    abstract fun bindGitHubUserDataSource(gitHubUserDataSource: GitHubUserDataSource): IGitUserDataSource

    @Binds
    @GitHub
    abstract fun bindGitHubCoil(gitHubTrendingRepoDataSource: GitHubCoilDelegate): ImageLoader
}