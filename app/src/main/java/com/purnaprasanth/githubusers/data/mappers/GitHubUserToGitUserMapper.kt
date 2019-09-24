package com.purnaprasanth.githubusers.data.mappers

import com.purnaprasanth.githubusers.data.Mapper
import com.purnaprasanth.githubusers.data.model.GitRepo
import com.purnaprasanth.githubusers.data.model.GitUser
import com.purnaprasanth.githubusers.data.toListMapper
import com.purnaprasanth.githubusers.github.data.GitHubRepo
import com.purnaprasanth.githubusers.github.data.GitHubUser
import com.purnaprasanth.githubusers.github.dataservices.IGitHubRepoServices
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Purna on 2019-09-24 as a part of GithubUsers
 **/

@Singleton
class GitHubUserToGitUserMapper @Inject constructor(
    private val githubRepoServices: IGitHubRepoServices,
    private val gitHubRepoToGitRepoMapper: Mapper<GitHubRepo, GitRepo>
) : Mapper<GitHubUser, GitUser> {

    override suspend fun map(from: GitHubUser) = GitUser(
        name = from.name,
        photo = from.avatarUrl,
        userName = from.login,
        repos = gitHubRepoToGitRepoMapper.toListMapper().map(githubRepoServices.getRepoDetails(from.reposUrl))
    )
}