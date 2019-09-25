package com.purnaprasanth.githubusers.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.databinding.DataBindingUtil
import com.purnaprasanth.githubusers.R
import com.purnaprasanth.githubusers.databinding.ViewLoadingBinding

/**
 * Created by Purna on 2019-09-25 as a part of GithubUsers
 **/
class LoadingView : FrameLayout {

    lateinit var binding: ViewLoadingBinding

    constructor(context: Context) : super(context) {
        initView()
    }

    constructor(context: Context, attributeSet: AttributeSet) : this(context, attributeSet, 0) {
        initView()
    }

    constructor(context: Context, attributeSet: AttributeSet, defStyleAttr: Int) : super(
        context,
        attributeSet,
        defStyleAttr
    ) {
        initView()
    }

    fun initView() {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        binding = DataBindingUtil.inflate(inflater, R.layout.view_loading, this, true)
    }
}