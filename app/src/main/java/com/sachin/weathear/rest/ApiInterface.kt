package com.sachin.weathear.rest

import com.sachin.weathear.rest.vo.ForecastData
import com.sachin.weathear.rest.vo.WeatherData
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("weather?q=India")
    fun getWatherData(@Query("appid") appId:String): Observable<WeatherData>

    @GET("forecast?id=1261768")  //Naroda ahmedabad
    fun getForecastData(@Query("appid") appId:String): Observable<ForecastData>
}