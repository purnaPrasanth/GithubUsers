package com.purnaprasanth.githubusers.async

import java.util.concurrent.Executor

/**
 * Created by Purna on 2019-09-10 as a part of GithubUsers
 **/

/**
 * Base Executor
 */

interface AppExecutor {
    val executor: Executor
}