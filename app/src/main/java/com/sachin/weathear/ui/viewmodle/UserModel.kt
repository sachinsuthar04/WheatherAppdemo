package com.sachin.weathear.ui.viewmodle

import androidx.lifecycle.MutableLiveData
import com.sachin.weathear.base.BaseViewModel
import com.sachin.weathear.rest.vo.Datum

class UserModel : BaseViewModel() {

    private val email = MutableLiveData<String>()
    private val fName = MutableLiveData<String>()
    private val lName = MutableLiveData<String>()
    private val thumb = MutableLiveData<String>()

    fun bind(userDatum: Datum) {
        this.email.value = userDatum.email
        this.fName.value = userDatum.first_name
        this.lName.value = userDatum.last_name
        this.thumb.value = userDatum.avatar
    }


    fun getThumbUrl():MutableLiveData<String>{
        return thumb
    }

    fun getFname():MutableLiveData<String>{
        return fName
    }

    fun getLname():MutableLiveData<String>{
        return lName
    }

    fun getEmail():MutableLiveData<String>{
        return email
    }
}