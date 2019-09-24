package com.purnaprasanth.githubusers.data.model

import com.purnaprasanth.githubusers.data.Mapper

/**
 * Created by Purna on 2019-09-23 as a part of GithubUsers
 **/

/**
 * Data Contract that the app depends on.
 *
 * The data from different sources of data will be mapped to this contract with the help of [Mapper]
 */

data class GitUser(
    val userName: String,
    val name: String,
    val photo: String,
    val repos: List<GitRepo>
)