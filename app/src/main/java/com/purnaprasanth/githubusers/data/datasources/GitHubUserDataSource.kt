package com.purnaprasanth.githubusers.data.datasources

import com.purnaprasanth.githubusers.data.Mapper
import com.purnaprasanth.githubusers.data.NetworkCallRunner
import com.purnaprasanth.githubusers.data.NetworkResult
import com.purnaprasanth.githubusers.data.model.GitUser
import com.purnaprasanth.githubusers.github.data.GitHubUser
import com.purnaprasanth.githubusers.github.dataservices.IGitHubUserServices
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Purna on 2019-09-24 as a part of GithubUsers
 **/

/**
 * An Implementation of [IGitUserDataSource] to fetch user details from GitHub API
 *
 * @param gitHubUserServices an implementation of [IGitHubUserServices] to communicate with GitHub API
 * @param networkCallRunner Single point for runner network calls
 * @param gitHubUserToGitUserMapper an Implementation [Mapper]
 */

@Singleton
class GitHubUserDataSource @Inject constructor(
    private val gitHubUserServices: IGitHubUserServices,
    private val networkCallRunner: NetworkCallRunner,
    private val gitHubUserToGitUserMapper: Mapper<GitHubUser, GitUser>
) : IGitUserDataSource {
    override suspend fun getGitUserData(userName: String): NetworkResult<GitUser> {
        return networkCallRunner.executeForResponse(gitHubUserToGitUserMapper) {
            gitHubUserServices.getUser(userName)
        }
    }
}