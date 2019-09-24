package com.purnaprasanth.githubusers.data.datasources

import com.purnaprasanth.githubusers.data.NetworkCallRunner
import com.purnaprasanth.githubusers.data.NetworkResult
import com.purnaprasanth.githubusers.data.mappers.GitHubUserToGitUserMapper
import com.purnaprasanth.githubusers.data.model.GitUser
import com.purnaprasanth.githubusers.github.dataservices.IGitHubUserServices
import javax.inject.Inject

/**
 * Created by Purna on 2019-09-24 as a part of GithubUsers
 **/

class GitHubUserDataSource @Inject constructor(
    private val gitHubUserServices: IGitHubUserServices,
    private val networkCallRunner: NetworkCallRunner,
    private val gitHubUserToGitUserMapper: GitHubUserToGitUserMapper
) : IGitUserDataSource {
    override suspend fun getGitUserData(userName: String): NetworkResult<GitUser> {
        return networkCallRunner.executeForResponse(gitHubUserToGitUserMapper) {
            gitHubUserServices.getUser(userName)
        }
    }
}