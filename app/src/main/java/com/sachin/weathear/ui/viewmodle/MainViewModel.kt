package com.sachin.weathear.ui.viewmodle

import android.view.View
import android.widget.Toast
import com.sachin.weathear.base.BaseViewModel
import com.sachin.weathear.rest.vo.ForecastData
import com.sachin.weathear.ui.adapter.UserAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.roundToInt


class MainViewModel : BaseViewModel() {

    private lateinit var disposable: Disposable
    val userAdapter: UserAdapter = UserAdapter({ item -> doClick(item) })

    lateinit var response: ForecastData
    val errorClickListener = View.OnClickListener { getData() }

    init {
        getData()
    }

    fun getData() {

        disposable = apiInterfaceBase.getForecastData("a6cba044d0f619768cd1bfe29166137b").subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { onRetrievePostListStart() }
            .doOnTerminate { onRetrievePostListFinish() }
            .subscribe(
                { result -> onRetrievePostListSuccess(result) },
                { onRetrievePostListError() }
            )
    }

    override fun onCleared() {
        super.onCleared()
        if (::disposable.isInitialized) disposable.dispose()
    }

    private fun onRetrievePostListStart() {
        loadingVisibility.value = View.VISIBLE
        errorMessage.value = null
    }

    private fun onRetrievePostListFinish() {
        loadingVisibility.value = View.GONE
    }

    private fun onRetrievePostListSuccess(userData: ForecastData) {
        response = userData

var temp = 0
        for(d in userData.list){
            if(userAdapter.myList.contains(d.dt_txt.substring(0,d.dt_txt.indexOf(' ')))){

            }else{

                userAdapter.myList.add(d.dt_txt.substring(0,d.dt_txt.indexOf(' ')))
            }

            d.main.temp = (d.main.temp - 273.12).roundToInt().toDouble()
            d.main.temp_min = (d.main.temp_min - 273.12).roundToInt().toDouble()
            d.main.temp_max = (d.main.temp_max - 273.12).roundToInt().toDouble()
            userData.list[temp] = d
            temp++
            print("----------"+d.dt_txt)
        }
        userAdapter.updateUserList(userData)
    }


    fun toSimpleString(date: String?) = with(date ?: Date()) {
        SimpleDateFormat("dd/MM/yyy").format(this)
    }

    private fun onRetrievePostListError() {
        errorMessage.value = "error"
    }

    private fun doClick(item: Any) {
        Toast.makeText(context, item.toString(), Toast.LENGTH_SHORT).show()
    }
}