package com.purnaprasanth.githubusers.async

import android.os.AsyncTask
import java.util.concurrent.Executor

/**
 * Created by Purna on 2019-09-10 as a part of GithubUsers
 **/

/**
 * Executor for Common Computational tasks
 */

class CommonExecutor : AppExecutor {
    override val executor: Executor
        get() = AsyncTask.THREAD_POOL_EXECUTOR
}