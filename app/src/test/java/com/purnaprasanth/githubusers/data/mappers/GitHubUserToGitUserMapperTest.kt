package com.purnaprasanth.githubusers.data.mappers

import com.purnaprasanth.githubusers.*
import com.purnaprasanth.githubusers.github.base.BaseTestRunner
import com.purnaprasanth.githubusers.github.dataservices.IGitHubRepoServices
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

/**
 * Created by Purna on 2019-09-24 as a part of GithubUsers
 */

@RunWith(JUnit4::class)
class GitHubUserToGitUserMapperTest : BaseTestRunner {

    @Mock
    lateinit var iGitHubRepoServices: IGitHubRepoServices

    @Mock
    lateinit var iGitHubRepoToGitRepoMapper: GitHubRepoToGitRepoMapper

    lateinit var gitHubUserToGitUserMapper: GitHubUserToGitUserMapper

    @Before
    override fun setUp() {
        MockitoAnnotations.initMocks(this)

        gitHubUserToGitUserMapper = GitHubUserToGitUserMapper(iGitHubRepoServices, iGitHubRepoToGitRepoMapper)
    }

    @Test
    fun map() {
        runBlocking {
            `when`(iGitHubRepoServices.getRepos(gitHubUser.reposUrl)).thenReturn(listOf(gitHubRepo1, gitHubRepo2))
            `when`(iGitHubRepoToGitRepoMapper.map(gitHubRepo1)).thenReturn(gitRepo1)
            `when`(iGitHubRepoToGitRepoMapper.map(gitHubRepo2)).thenReturn(gitRepo2)

            val mappedResult = gitHubUserToGitUserMapper.map(gitHubUser)

            assert(gitUser == mappedResult)
        }
    }

    @After
    override fun tearDown() {

    }
}