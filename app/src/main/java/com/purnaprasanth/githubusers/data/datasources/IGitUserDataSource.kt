package com.purnaprasanth.githubusers.data.datasources

import com.purnaprasanth.githubusers.data.NetworkResult
import com.purnaprasanth.githubusers.data.model.GitUser

/**
 * Created by Purna on 2019-09-24 as a part of GithubUsers
 **/

/**
 * A Contract to be implemented by multiple data sources of GitUser into the App from different Sources Data
 *
 * @see [GitHubUserDataSource]
 */

interface IGitUserDataSource {

    suspend fun getGitUserData(userName: String): NetworkResult<GitUser>
}