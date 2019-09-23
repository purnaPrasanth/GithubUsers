package com.purnaprasanth.githubusers.github.okhttp

import android.content.Context
import coil.DefaultRequestOptions
import coil.ImageLoader
import coil.request.GetRequest
import coil.request.LoadRequest
import com.purnaprasanth.githubusers.base.AppDispatchers
import okhttp3.OkHttpClient

/**
 * Created by Purna on 2019-09-23 as a part of GithubUsers
 **/

/**
 * A Delegate for loading images from GitHub API
 */

class GitHubCoilDelegate(
    appContext: Context,
    okHttpClient: OkHttpClient,
    appDispatchers: AppDispatchers
) : ImageLoader {

    private val githubOkHttp = okHttpClient.newBuilder().build()

    private val coilImageLoader: ImageLoader by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
        ImageLoader(appContext) {
            crossfade(true)
            okHttpClient(githubOkHttp)
            availableMemoryPercentage(0.4)
            bitmapPoolPercentage(0.5)
            dispatcher(appDispatchers.ioDispatcher)
        }
    }

    override val defaults: DefaultRequestOptions
        get() = coilImageLoader.defaults

    override fun clearMemory() {
        coilImageLoader.clearMemory()
    }

    override suspend fun get(request: GetRequest) = coilImageLoader.get(request)

    override fun load(request: LoadRequest) = coilImageLoader.load(request)

    override fun shutdown() {
        coilImageLoader.shutdown()
    }
}