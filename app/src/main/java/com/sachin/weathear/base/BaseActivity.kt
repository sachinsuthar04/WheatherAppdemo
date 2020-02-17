package com.sachin.weathear.base

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sachin.weathear.database.UserDao
import javax.inject.Inject

open class BaseActivity : AppCompatActivity() {

    @Inject
    lateinit var context: Context
    @Inject
    lateinit var preferences: SharedPreferences
    @Inject
    lateinit var editor: SharedPreferences.Editor
    @Inject 
    lateinit var userDao: UserDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //inject BaseActivity for dagger magic methods
        MyApplication.application.appComponent.inject(this)
    }
}