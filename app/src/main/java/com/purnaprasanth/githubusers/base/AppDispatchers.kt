package com.purnaprasanth.githubusers.base

import kotlinx.coroutines.CoroutineDispatcher

/**
 * Created by Purna on 2019-09-10 as a part of GithubUsers
 **/
/**
 * AppDispatchers to be used across app
 * @param mainDispatcher The dispatcher for Operations on Main Thread
 * @param ioDispatcher The dispatcher for IO Operations
 * @param commonDispatcher The Dispatcher for Common Computational Operations
 *
 * Usually created from [AppExecutors]
 */

data class AppDispatchers(
    val mainDispatcher: CoroutineDispatcher,
    val ioDispatcher: CoroutineDispatcher,
    val commonDispatcher: CoroutineDispatcher
)