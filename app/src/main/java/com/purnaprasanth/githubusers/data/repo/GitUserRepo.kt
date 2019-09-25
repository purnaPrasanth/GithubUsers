package com.purnaprasanth.githubusers.data.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.purnaprasanth.githubusers.annotation.GitHub
import com.purnaprasanth.githubusers.base.AppDispatchers
import com.purnaprasanth.githubusers.base.util.MoshiUtils
import com.purnaprasanth.githubusers.baseandroid.SharedPrefManager
import com.purnaprasanth.githubusers.data.datasources.IGitUserDataSource
import com.purnaprasanth.githubusers.data.model.GitUser
import com.purnaprasanth.githubusers.data.persist.sharedpref.PREF_FETCHED_GIT_USERS
import com.purnaprasanth.githubusers.util.stringLiveData
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Created by Purna on 2019-09-24 as a part of GithubUsers
 **/

/**
 * An Application Repository to fetch user related data.
 */

class GitUserRepo @Inject constructor(
    @GitHub private val gitHubUserDataSource: IGitUserDataSource,
    private val appDispatchers: AppDispatchers,
    private val sharedPrefManager: SharedPrefManager,
    private val moshiUtils: MoshiUtils
) {

    suspend fun getGitUserDetails(username: String) = coroutineScope {
        withContext(appDispatchers.ioDispatcher) {
            gitHubUserDataSource.getGitUserData(username)
        }
    }

    suspend fun saveUserInSharedPref(user: GitUser) = coroutineScope {
        launch(appDispatchers.ioDispatcher) {
            val users =
                sharedPrefManager.getListOfObjects(String::class.java, PREF_FETCHED_GIT_USERS).orEmpty().toMutableList()

            val userSet = mutableSetOf<String>()

            users.forEach { userSet.add(it) }
            userSet.add(user.userName)
            sharedPrefManager.putListOfObjects(String::class.java, PREF_FETCHED_GIT_USERS, userSet.toList())
        }
    }

    fun fetchedUserLiveData(): LiveData<List<String>> {
        return Transformations.map(sharedPrefManager.stringLiveData(PREF_FETCHED_GIT_USERS, "")) {
            moshiUtils.deSerializeCollectionOfObjects(String::class.java, it)
        }
    }
}