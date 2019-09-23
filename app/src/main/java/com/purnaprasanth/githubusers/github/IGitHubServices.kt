package com.purnaprasanth.githubusers.github

import com.purnaprasanth.githubusers.github.dataservices.IGitHubRepoServices
import com.purnaprasanth.githubusers.github.dataservices.IGitHubUserServices

/**
 * Created by Purna on 2019-09-23 as a part of GithubUsers
 **/

/**
 * An Contract to provide a family of Data Services for Github API
 */

interface IGitHubServices {
    val gitHubUserServices: IGitHubUserServices

    val gitHubRepoServices: IGitHubRepoServices
}