package com.sachin.weathear.rest.vo

data class ForecastData(
    var cod: String,
    var message: Int,
    var cnt: Int,
    var list: java.util.List<List>,
    var city: City
)

data class City(
    var id: Int,
    var name: String,
    var coord: Coord,
    var country: String,
    var timmezone: Int,
    var sunrise: Int,
    var sunset: Int
)

data class List(
    var dt: Int,
    var main: Main,
    var weather: java.util.List<Weather>,
    var clouds: Clouds,
    var wind: Wind,
    var sys: Sys,
    var dt_txt: String,
    var rain: Rain,
    var snow: Snow
)

data class Rain(
    var _3h: Double
)


data class Snow(
    var _3h: Double
)