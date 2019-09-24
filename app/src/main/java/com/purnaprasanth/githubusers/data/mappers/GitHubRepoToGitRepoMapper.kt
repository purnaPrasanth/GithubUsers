package com.purnaprasanth.githubusers.data.mappers

import com.purnaprasanth.githubusers.data.Mapper
import com.purnaprasanth.githubusers.data.model.GitRepo
import com.purnaprasanth.githubusers.github.data.GitHubRepo
import javax.inject.Inject

/**
 * Created by Purna on 2019-09-24 as a part of GithubUsers
 **/

class GitHubRepoToGitRepoMapper @Inject constructor() : Mapper<GitHubRepo, GitRepo> {
    override suspend fun map(from: GitHubRepo) = GitRepo(
        name = from.name,
        description = from.description,
        starsCount = from.stargazersCount,
        link = from.svnUrl
    )
}