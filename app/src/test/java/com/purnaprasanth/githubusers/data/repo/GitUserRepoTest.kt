package com.purnaprasanth.githubusers.data.repo

import android.app.Application
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.core.app.ApplicationProvider
import com.purnaprasanth.githubusers.base.AppDispatchers
import com.purnaprasanth.githubusers.base.util.MoshiUtils
import com.purnaprasanth.githubusers.baseandroid.SharedPrefManager
import com.purnaprasanth.githubusers.data.NetworkError
import com.purnaprasanth.githubusers.data.NetworkSuccess
import com.purnaprasanth.githubusers.data.datasources.IGitUserDataSource
import com.purnaprasanth.githubusers.gitHubUser
import com.purnaprasanth.githubusers.gitUser
import com.purnaprasanth.githubusers.github.base.BaseTestRunner
import com.squareup.moshi.Moshi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.robolectric.RobolectricTestRunner
import java.io.IOException

/**
 * Created by Purna on 2019-09-24 as a part of GithubUsers
 */

@RunWith(RobolectricTestRunner::class)
class GitUserRepoTest : BaseTestRunner {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    val moshiUtils = MoshiUtils(Moshi.Builder().build())

    val context = ApplicationProvider.getApplicationContext<Application>()

    lateinit var gitUserRepo: GitUserRepo

    @Mock
    lateinit var iGitUserDataSource: IGitUserDataSource

    private val appDispatchers = AppDispatchers(
        ioDispatcher = Dispatchers.IO,
        mainDispatcher = Dispatchers.Main,
        commonDispatcher = Dispatchers.Default
    )

    @Before
    override fun setUp() {
        MockitoAnnotations.initMocks(this)

        gitUserRepo = GitUserRepo(
            iGitUserDataSource,
            appDispatchers,
            SharedPrefManager(moshiUtils, context),
            moshiUtils
        )
    }

    @Test
    fun getGitUserDetailsSuccess() {
        runBlocking {
            `when`(iGitUserDataSource.getGitUserData(gitHubUser.login)).thenReturn(NetworkSuccess(gitUser))

            val result = gitUserRepo.getGitUserDetails(gitHubUser.login)

            assert(result is NetworkSuccess)
            assert((result as NetworkSuccess).data == gitUser)
        }
    }

    @Test
    fun getGitUserDetailsError() {
        runBlocking {
            val errorReason = "Some Reason"
            `when`(iGitUserDataSource.getGitUserData(gitHubUser.login)).thenReturn(NetworkError(IOException(errorReason)))

            val result = gitUserRepo.getGitUserDetails(gitHubUser.login)

            assert(result is NetworkError)
            assert((result as NetworkError).exception.message == errorReason)
        }
    }

    @After
    override fun tearDown() {

    }
}