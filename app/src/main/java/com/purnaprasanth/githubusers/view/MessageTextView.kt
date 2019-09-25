package com.purnaprasanth.githubusers.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.databinding.DataBindingUtil
import com.purnaprasanth.githubusers.R
import com.purnaprasanth.githubusers.databinding.ViewMessageBinding

/**
 * Created by Purna on 2019-09-25 as a part of GithubUsers
 **/
class MessageTextView : FrameLayout {

    lateinit var binding: ViewMessageBinding

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
        binding = DataBindingUtil.inflate(inflater, R.layout.view_message, this, true)
    }

    fun setMessage(text: String?) {
        binding.messageTv.text = text
    }
}