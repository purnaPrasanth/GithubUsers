package com.purnaprasanth.githubusers.main

import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import com.purnaprasanth.githubusers.R
import com.purnaprasanth.githubusers.baseandroid.BaseActivity
import com.purnaprasanth.githubusers.databinding.ActivityMainBinding

/**
 * Created by Purna on 2019-09-10 as a part of GithubUsers
 **/

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    override fun initUI() {
        binding.searchEtv.setOnEditorActionListener { textView, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH
                || actionId == EditorInfo.IME_ACTION_DONE
                || event.action == KeyEvent.ACTION_DOWN
                && event.keyCode == KeyEvent.KEYCODE_ENTER
            ) {
                submitText(textView.text.toString())
                return@setOnEditorActionListener true
            }
            // Return true if you have consumed the action, else false.
            return@setOnEditorActionListener false
        }
    }

    private fun submitText(searchTag: String) {
        // TODO()
    }
}