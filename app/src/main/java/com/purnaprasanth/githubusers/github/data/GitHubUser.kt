package com.purnaprasanth.githubusers.github.data

import com.squareup.moshi.Json

data class GitHubUser(
    @field:Json(name = "avatar_url")
    val avatarUrl: String,
    @field:Json(name = "events_url")
    val eventsUrl: String,
    @field:Json(name = "following_url")
    val followingUrl: String,
    @field:Json(name = "gists_url")
    val gistsUrl: String,
    @field:Json(name = "gravatar_id")
    val gravatarId: String,
    @field:Json(name = "html_url")
    val htmlUrl: String,
    @field:Json(name = "id")
    val id: Int,
    @field:Json(name = "login")
    val login: String,
    @field:Json(name = "node_id")
    val nodeId: String,
    @field:Json(name = "organizations_url")
    val organizationsUrl: String,
    @field:Json(name = "received_events_url")
    val receivedEventsUrl: String,
    @field:Json(name = "repos_url")
    val reposUrl: String,
    @field:Json(name = "site_admin")
    val siteAdmin: Boolean,
    @field:Json(name = "starred_url")
    val starredUrl: String,
    @field:Json(name = "subscriptions_url")
    val subscriptionsUrl: String,
    @field:Json(name = "type")
    val type: String,
    @field:Json(name = "url")
    val url: String,
    @field:Json(name = "updated_at")
    val updatedAt: String,
    @field:Json(name = "bio")
    val bio: String? = null,
    @field:Json(name = "blog")
    val blog: String,
    @field:Json(name = "company")
    val company: String? = null,
    @field:Json(name = "created_at")
    val createdAt: String,
    @field:Json(name = "email")
    val email: String? = null,
    @field:Json(name = "followers")
    val followers: Int,
    @field:Json(name = "followers_url")
    val followersUrl: String,
    @field:Json(name = "following")
    val following: Int,
    @field:Json(name = "hireable")
    val hireable: Boolean? = null,
    @field:Json(name = "location")
    val location: String? = null,
    @field:Json(name = "name")
    val name: String? = null,
    @field:Json(name = "public_gists")
    val publicGists: Int,
    @field:Json(name = "public_repos")
    val publicRepos: Int
)