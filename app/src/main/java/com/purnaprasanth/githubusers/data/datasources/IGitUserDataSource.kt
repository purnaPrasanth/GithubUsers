package com.purnaprasanth.githubusers.data.datasources

import com.purnaprasanth.githubusers.data.NetworkError
import com.purnaprasanth.githubusers.data.NetworkResult
import com.purnaprasanth.githubusers.data.NetworkSuccess
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

    /**
     * To fetch the user details with username from GitHub API
     *
     * @param userName username/login of the user to fetched from GitHub API
     * @return [NetworkSuccess] if this data source succeeds in fetching the user details, [NetworkError] if this data source fails in fetching the user details
     */
    suspend fun getGitUserData(userName: String): NetworkResult<GitUser>
}