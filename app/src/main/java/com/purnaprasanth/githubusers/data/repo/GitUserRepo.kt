package com.purnaprasanth.githubusers.data.repo

import com.purnaprasanth.githubusers.annotation.GitHub
import com.purnaprasanth.githubusers.base.AppDispatchers
import com.purnaprasanth.githubusers.data.datasources.GitHubUserDataSource
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Created by Purna on 2019-09-24 as a part of GithubUsers
 **/

class GitUserRepo @Inject constructor(
    @GitHub private val gitHubUserDataSource: GitHubUserDataSource,
    private val appDispatchers: AppDispatchers
) {

    suspend fun getGitUserDetails(username: String) = coroutineScope {
        withContext(appDispatchers.ioDispatcher) {
            gitHubUserDataSource.getGitUserData(username)
        }
    }
}