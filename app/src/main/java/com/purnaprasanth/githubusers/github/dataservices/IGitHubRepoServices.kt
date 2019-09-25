package com.purnaprasanth.githubusers.github.dataservices

import com.purnaprasanth.githubusers.github.data.GitHubRepo
import retrofit2.http.GET
import retrofit2.http.Url

/**
 * Created by Purna on 2019-09-23 as a part of GithubUsers
 **/

/**
 * Contract for fetching Repo Related data from GitHub API
 */

interface IGitHubRepoServices {

    @GET
    suspend fun getRepos(@Url repoUrl: String): List<GitHubRepo>
}