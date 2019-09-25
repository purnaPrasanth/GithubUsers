package com.purnaprasanth.githubusers.data.model

import com.purnaprasanth.githubusers.data.Mapper

/**
 * Created by Purna on 2019-09-24 as a part of GithubUsers
 **/

/**
 * Data Contract for Repo that the app depends on.
 *
 * The data from different sources of data will be mapped to this contract with the help of [Mapper]
 */

data class GitRepo(
    val name: String,
    val description: String? = null,
    val link: String,
    val starsCount: Int
)