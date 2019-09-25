package com.purnaprasanth.githubusers.view

import android.content.Context
import android.util.AttributeSet
import android.view.animation.AnimationUtils
import android.widget.ViewFlipper
import com.purnaprasanth.githubusers.R
import com.purnaprasanth.githubusers.baseandroid.ErrorViewState
import com.purnaprasanth.githubusers.baseandroid.LoadingViewState
import com.purnaprasanth.githubusers.baseandroid.SuccessViewState
import com.purnaprasanth.githubusers.baseandroid.ViewState
import com.purnaprasanth.githubusers.data.model.GitUser

/**
 * Created by Purna on 2019-09-24 as a part of GithubUsers
 **/

class UserStateViewFlipper : ViewFlipper {

    val TAG = "UserStateViewFlipper"

    lateinit var userDetailView: UserDetailView

    lateinit var loadingView: LoadingView

    lateinit var errorText: MessageTextView

    lateinit var directiveText: MessageTextView

    constructor(context: Context) : this(context, null) {
        initView()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        initView()
    }

    private fun initView() {
        userDetailView = UserDetailView(context)
        loadingView = LoadingView(context)
        errorText = MessageTextView(context)
        directiveText = MessageTextView(context)

        directiveText.setMessage(context.getString(R.string.search_for_user))

        addView(userDetailView, POS_USER_DETAIL)
        addView(loadingView, POS_LOADING)
        addView(errorText, POS_ERROR)
        addView(directiveText, POS_DIRECTIVE)
        inAnimation = AnimationUtils.loadAnimation(context, R.anim.slide_in_right)
        outAnimation = AnimationUtils.loadAnimation(context, R.anim.slide_out_left)
    }

    fun setUserDetailState(userDetailState: ViewState<GitUser>?) {
        when (userDetailState) {
            is SuccessViewState -> {
                userDetailView.setUserDetail(userDetailState.data)
                displayedChild = POS_USER_DETAIL
            }
            is ErrorViewState -> {
                errorText.setMessage(userDetailState.exception.message.orEmpty())
                displayedChild = POS_ERROR
            }
            is LoadingViewState -> {
                displayedChild = POS_LOADING
            }
            else -> {
                displayedChild = POS_DIRECTIVE
            }
        }
    }

    companion object {
        const val POS_USER_DETAIL = 0
        const val POS_LOADING = 1
        const val POS_ERROR = 2
        const val POS_DIRECTIVE = 3
    }
}