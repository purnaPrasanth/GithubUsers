package com.purnaprasanth.githubusers.base

import java.util.concurrent.Executor

/**
 * Created by Purna on 2019-09-10 as a part of GithubUsers
 **/

/**
 * AppExecutors to be used across App
 * @param mainDispatcher The Executor for Operations on Main Thread
 * @param ioDispatcher The Executor for IO Operations
 * @param commonDispatcher The Executor for Common Computational Operations
 *
 * Usually Used to create [AppDispatchers]
 */
data class AppExecutors(
    val mainExecutor: Executor,
    val ioExecutor: Executor,
    val commonExecutor: Executor
)