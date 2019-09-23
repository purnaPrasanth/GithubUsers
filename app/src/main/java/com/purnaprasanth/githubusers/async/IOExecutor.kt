package com.purnaprasanth.githubusers.async

import com.purnaprasanth.githubusers.base.util.threadFactory
import java.util.concurrent.Executor
import java.util.concurrent.SynchronousQueue
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit

/**
 * Created by Purna on 2019-09-10 as a part of GithubUsers
 **/

/**
 * Executor for IO Operational tasks
 */

class IOExecutor : AppExecutor {
    override val executor: Executor
        get() = _executor

    private val _executor = ThreadPoolExecutor(
        0,
        10,
        15,
        TimeUnit.SECONDS,
        SynchronousQueue<Runnable>(),
        threadFactory("App IO Executor", false)
    )
}