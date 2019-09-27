package com.purnaprasanth.githubusers.main

import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.widget.ArrayAdapter
import androidx.lifecycle.Observer
import coil.api.load
import coil.transform.CircleCropTransformation
import com.purnaprasanth.githubusers.R
import com.purnaprasanth.githubusers.baseandroid.BaseActivity
import com.purnaprasanth.githubusers.baseandroid.SuccessViewState
import com.purnaprasanth.githubusers.databinding.ActivityMainBinding
import javax.inject.Inject

/**
 * Created by Purna on 2019-09-10 as a part of GithubUsers
 **/

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    override val TAG: String
        get() = "MainActivity"

    @Inject
    lateinit var searchUserVM: SearchUserVM

    override fun initUI() {
        val adapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_dropdown_item_1line, mutableListOf()
        )
        binding.gitUserEtv.setAdapter<ArrayAdapter<String>>(adapter)
        binding.viewModel = searchUserVM
        searchUserVM.fetchedUsers.observe(this, Observer {
            val mutableList = it.toMutableList()
            adapter.clear()
            adapter.addAll(mutableList)
        })
        searchUserVM.userDetailState.observe(this, Observer {
            if (it is SuccessViewState) binding.userDetailStateView.userDetailView.binding.userIv.load(it.data.photo) {
                transformations(CircleCropTransformation())
            }
        })
        binding.gitUserEtv.setOnEditorActionListener { view, actionId, event ->
            if ((event != null && (event.keyCode == KeyEvent.KEYCODE_ENTER)) || (actionId == EditorInfo.IME_ACTION_DONE)) {
                searchUser(binding.gitUserEtv.text.toString())
            }
            return@setOnEditorActionListener false
        }
    }

    private fun searchUser(username: String) {
        searchUserVM.getUserDetail(username)
    }
}