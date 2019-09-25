package com.purnaprasanth.githubusers.baseandroid

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import com.purnaprasanth.githubusers.base.util.MoshiUtils

/**
 * Created by Purna on 2019-09-25 as a part of GithubUsers
 **/

class SharedPrefManager(
    private val moshiUtils: MoshiUtils,
    context: Context
) {

    private val sharedPrefs: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

    fun getBoolean(key: String, defaultValue: Boolean): Boolean {
        return sharedPrefs.getBoolean(key, defaultValue)
    }

    fun getInt(key: String, defaultValue: Int): Int {
        return sharedPrefs.getInt(key, defaultValue)
    }

    fun getFloat(key: String, defaultValue: Float): Float {
        return sharedPrefs.getFloat(key, defaultValue)
    }

    fun getLong(key: String, defaultValue: Long): Long {
        return sharedPrefs.getLong(key, defaultValue)
    }

    fun getString(key: String, defaultValue: String): String {
        return sharedPrefs.getString(key, defaultValue)!!
    }

    fun getStringSet(key: String, defaultValue: Set<String>): Set<String> {
        return sharedPrefs.getStringSet(key, defaultValue)!!
    }

    fun <T : Any> getObject(cls: Class<T>, key: String): T? {
        val dataString = sharedPrefs.getString(key, null) ?: return null
        return moshiUtils.deseriaLizeObject(cls, dataString)
    }

    fun <T : Any> getListOfObjects(cls: Class<T>, key: String): List<T>? {
        val dataString = sharedPrefs.getString(key, null) ?: return null
        return moshiUtils.deSerializeCollectionOfObjects(cls, dataString)
    }

    fun putBoolean(key: String, value: Boolean): Boolean {
        val editor = sharedPrefs.edit()
        editor.putBoolean(key, value)
        return editor.commit()
    }

    fun putInt(key: String, value: Int): Boolean {
        val editor = sharedPrefs.edit()
        editor.putInt(key, value)
        return editor.commit()
    }

    fun putFloat(key: String, value: Float): Boolean {
        val editor = sharedPrefs.edit()
        editor.putFloat(key, value)
        return editor.commit()
    }

    fun putLong(key: String, value: Long): Boolean {
        val editor = sharedPrefs.edit()
        editor.putLong(key, value)
        return editor.commit()
    }

    fun putString(key: String, value: String): Boolean {
        val editor = sharedPrefs.edit()
        editor.putString(key, value)
        return editor.commit()
    }

    fun putStringSet(key: String, value: Set<String>): Boolean {
        val editor = sharedPrefs.edit()
        editor.putStringSet(key, value)
        return editor.commit()
    }

    fun <T : Any> putObject(cls: Class<T>, key: String, obj: T?): Boolean {
        val editor = sharedPrefs.edit()
        val dataString = if (obj != null) moshiUtils.serializeObject(cls, obj) else null
        editor.putString(key, dataString)
        return editor.commit()
    }

    fun <T : Any> putListOfObjects(cls: Class<T>, key: String, objects: List<T>?): Boolean {
        val editor = sharedPrefs.edit()
        val dataString = if (objects != null) moshiUtils.serializeCollectionOfObjects(cls, objects) else null
        editor.putString(key, dataString)
        return editor.commit()
    }

    fun registerOnSharedPreferenceChangeListener(listener: SharedPreferences.OnSharedPreferenceChangeListener) {
        sharedPrefs.registerOnSharedPreferenceChangeListener(listener)
    }

    fun unRegisterOnSharedPreferenceChangeListener(listener: SharedPreferences.OnSharedPreferenceChangeListener) {
        sharedPrefs.unregisterOnSharedPreferenceChangeListener(listener)
    }
}