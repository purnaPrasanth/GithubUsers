package com.purnaprasanth.githubusers.main

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.purnaprasanth.githubusers.base.AppDispatchers
import com.purnaprasanth.githubusers.baseandroid.*
import com.purnaprasanth.githubusers.data.NetworkError
import com.purnaprasanth.githubusers.data.NetworkSuccess
import com.purnaprasanth.githubusers.data.model.GitUser
import com.purnaprasanth.githubusers.data.repo.GitUserRepo
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Purna on 2019-09-24 as a part of GithubUsers
 **/

class SearchUserVM @Inject constructor(
    application: Application,
    appDispatchers: AppDispatchers,
    private val gitUserRepo: GitUserRepo
) : BaseViewModel(application, appDispatchers) {

    private val _userDetailState = MutableLiveData<ViewState<GitUser>>()

    val fetchedUsers = gitUserRepo.fetchedUserLiveData()

    val userDetailState: LiveData<ViewState<GitUser>>
        get() = _userDetailState

    fun getUserDetail(username: String) {
        launch(appDispatchers.mainDispatcher) {
            _userDetailState.value = LoadingViewState()
            when (val result = gitUserRepo.getGitUserDetails(username)) {
                is NetworkSuccess -> {
                    _userDetailState.value = SuccessViewState(result.data)
                    gitUserRepo.saveUserInSharedPref(result.data)
                }
                is NetworkError -> {
                    _userDetailState.value = ErrorViewState(result.exception, "")
                }
            }
        }
    }
}