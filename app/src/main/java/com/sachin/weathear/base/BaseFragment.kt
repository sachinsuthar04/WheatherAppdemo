package com.sachin.weathear.base

import android.content.SharedPreferences
import androidx.fragment.app.Fragment
import com.sachin.weathear.database.UserDao
import javax.inject.Inject

open class BaseFragment : Fragment() {

    @Inject
    lateinit var preferences: SharedPreferences
    @Inject
    lateinit var editor: SharedPreferences.Editor
    @Inject
    lateinit var userDao: UserDao

}