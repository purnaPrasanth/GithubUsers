package com.purnaprasanth.githubusers.data.mappers

import com.purnaprasanth.githubusers.data.toListMapper
import com.purnaprasanth.githubusers.gitHubRepo1
import com.purnaprasanth.githubusers.gitHubRepo2
import com.purnaprasanth.githubusers.gitRepo1
import com.purnaprasanth.githubusers.gitRepo2
import com.purnaprasanth.githubusers.github.base.BaseTestRunner
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test

/**
 * Created by Purna on 2019-09-24 as a part of GithubUsers
 */
class GitHubRepoToGitRepoMapperTest : BaseTestRunner {

    lateinit var iGitHubRepoToGitRepoMapper: GitHubRepoToGitRepoMapper

    @Before
    override fun setUp() {
        iGitHubRepoToGitRepoMapper = GitHubRepoToGitRepoMapper()
    }

    @Test
    fun map() {
        runBlocking {
            val mappedRepo = iGitHubRepoToGitRepoMapper.map(gitHubRepo1)

            assert(mappedRepo == gitRepo1)
        }
    }

    @Test
    fun mapList() {
        runBlocking {
            val mappedRepos = iGitHubRepoToGitRepoMapper.toListMapper().map(listOf(gitHubRepo1, gitHubRepo2))
            assert(mappedRepos == listOf(gitRepo1, gitRepo2))
        }
    }

    @After
    override fun tearDown() {

    }
}