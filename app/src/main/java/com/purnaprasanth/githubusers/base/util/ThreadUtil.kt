package com.purnaprasanth.githubusers.base.util

import java.util.concurrent.ThreadFactory

/**
 * Created by Purna on 2019-09-23 as a part of GithubUsers
 **/

fun threadFactory(name: String, daemon: Boolean) = ThreadFactory { r ->
    val result = Thread(r, name)
    result.isDaemon = daemon
    result
}