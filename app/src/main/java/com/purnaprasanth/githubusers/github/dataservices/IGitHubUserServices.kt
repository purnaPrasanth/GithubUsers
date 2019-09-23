package com.purnaprasanth.githubusers.github.dataservices

import com.purnaprasanth.githubusers.github.data.GitHubUser
import retrofit2.http.GET
import retrofit2.http.Path
import java.io.IOException

/**
 * Created by Purna on 2019-09-23 as a part of GithubUsers
 **/

/**
 * Contract for fetching User Related data from GitHub API
 */

interface IGitHubUserServices {

    @GET("/users/{username}")
    @Throws(IOException::class)
    suspend fun getUser(@Path("username") userName: String): GitHubUser
}