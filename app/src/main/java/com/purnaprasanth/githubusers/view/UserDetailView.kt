package com.purnaprasanth.githubusers.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.purnaprasanth.githubusers.R
import com.purnaprasanth.githubusers.data.model.GitUser
import com.purnaprasanth.githubusers.databinding.ViewUserDetailsBinding
import com.purnaprasanth.githubusers.main.GitRepoItemDiffCallback
import com.purnaprasanth.githubusers.main.RepoRVAdapter

/**
 * Created by Purna on 2019-09-24 as a part of GithubUsers
 **/
class UserDetailView : ConstraintLayout {

    lateinit var binding: ViewUserDetailsBinding

    val repoRVAdapter = RepoRVAdapter(context, GitRepoItemDiffCallback())

    constructor(context: Context) : super(context) {
        initView()
    }

    constructor(context: Context, attributes: AttributeSet) : super(context, attributes) {
        initView()
    }

    constructor(context: Context, attributes: AttributeSet, defStyle: Int) : super(context, attributes, defStyle) {
        initView()
    }

    private fun initView() {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        binding = DataBindingUtil.inflate(inflater, R.layout.view_user_details, this, true)
        binding.repoRv.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        binding.repoRv.adapter = repoRVAdapter
    }

    fun setUserDetail(user: GitUser?) {
        binding.gitUser = user
        repoRVAdapter.submitList(user?.repos.orEmpty())
    }
}