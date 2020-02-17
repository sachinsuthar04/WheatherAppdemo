package com.sachin.weathear.base

import android.content.Context
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sachin.weathear.rest.ApiInterface
import javax.inject.Inject
import javax.inject.Named

abstract class BaseViewModel : ViewModel() {

    @Named("base")
    @Inject
    lateinit var apiInterfaceBase: ApiInterface

    @Inject
    lateinit var context: Context

    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
    val errorMessage: MutableLiveData<String> = MutableLiveData()

    init {
        loadingVisibility.value = View.GONE
        MyApplication.application.appComponent.inject(this)
    }
}