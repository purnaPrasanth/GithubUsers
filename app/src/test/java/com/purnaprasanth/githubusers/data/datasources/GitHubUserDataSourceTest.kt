package com.purnaprasanth.githubusers.data.datasources

import com.purnaprasanth.githubusers.data.NetworkCallRunner
import com.purnaprasanth.githubusers.data.NetworkError
import com.purnaprasanth.githubusers.data.NetworkSuccess
import com.purnaprasanth.githubusers.data.mappers.GitHubRepoToGitRepoMapper
import com.purnaprasanth.githubusers.data.mappers.GitHubUserToGitUserMapper
import com.purnaprasanth.githubusers.gitHubRepo1
import com.purnaprasanth.githubusers.gitHubRepo2
import com.purnaprasanth.githubusers.gitHubUser
import com.purnaprasanth.githubusers.gitUser
import com.purnaprasanth.githubusers.github.base.BaseTestRunner
import com.purnaprasanth.githubusers.github.dataservices.IGitHubRepoServices
import com.purnaprasanth.githubusers.github.dataservices.IGitHubUserServices
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import java.io.IOException

/**
 * Created by Purna on 2019-09-24 as a part of GithubUsers
 */

@RunWith(JUnit4::class)
class GitHubUserDataSourceTest : BaseTestRunner {

    @Mock
    lateinit var iGitHubUserServices: IGitHubUserServices

    @Mock
    lateinit var iGitHubRepoServices: IGitHubRepoServices

    private val networkCallRunner = NetworkCallRunner()

    lateinit var gitHubUserDataSource: GitHubUserDataSource

    @Before
    override fun setUp() {
        MockitoAnnotations.initMocks(this)

        gitHubUserDataSource = GitHubUserDataSource(
            iGitHubUserServices,
            networkCallRunner,
            GitHubUserToGitUserMapper(iGitHubRepoServices, GitHubRepoToGitRepoMapper())
        )
    }

    @Test
    fun getGitUserDataSuccess() {
        runBlocking {
            `when`(iGitHubUserServices.getUser(gitHubUser.login)).thenReturn(gitHubUser)
            `when`(iGitHubRepoServices.getRepos(gitHubUser.reposUrl)).thenReturn(listOf(gitHubRepo1, gitHubRepo2))

            val result = gitHubUserDataSource.getGitUserData(gitHubUser.login)

            assert(result is NetworkSuccess)
            assert((result as NetworkSuccess).data == gitUser)
        }
    }

    @Test
    fun getGitUserDataError() {
        runBlocking {
            val errorReason = "Some Reason"
            `when`(iGitHubUserServices.getUser(gitHubUser.login)).thenThrow(IOException(errorReason))
            `when`(iGitHubRepoServices.getRepos(gitHubUser.reposUrl)).thenReturn(listOf(gitHubRepo1, gitHubRepo2))

            val result = gitHubUserDataSource.getGitUserData(gitHubUser.login)

            assert(result is NetworkError)
            assert((result as NetworkError).exception.message.equals(errorReason))
        }
    }

    @After
    override fun tearDown() {

    }
}