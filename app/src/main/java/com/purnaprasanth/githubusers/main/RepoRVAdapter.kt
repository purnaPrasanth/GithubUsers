package com.purnaprasanth.githubusers.main

import android.content.Context
import androidx.recyclerview.widget.DiffUtil
import com.purnaprasanth.githubusers.R
import com.purnaprasanth.githubusers.baseandroid.SingleTypeBaseRvAdapter
import com.purnaprasanth.githubusers.data.model.GitRepo
import com.purnaprasanth.githubusers.databinding.RepoItemBinding
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Purna on 2019-09-24 as a part of GithubUsers
 **/

class RepoRVAdapter(context: Context, gitRepoItemDiffCallback: GitRepoItemDiffCallback) :
    SingleTypeBaseRvAdapter<RepoItemBinding, GitRepo>(context, R.layout.repo_item, gitRepoItemDiffCallback) {

    override fun onBindViewHolder(binding: RepoItemBinding, position: Int) {
        binding.repo = getItem(position)
    }
}

@Singleton
class GitRepoItemDiffCallback @Inject constructor() : DiffUtil.ItemCallback<GitRepo>() {
    override fun areItemsTheSame(oldItem: GitRepo, newItem: GitRepo): Boolean {
        return oldItem.link == newItem.link
    }

    override fun areContentsTheSame(oldItem: GitRepo, newItem: GitRepo): Boolean {
        return oldItem == newItem
    }

}