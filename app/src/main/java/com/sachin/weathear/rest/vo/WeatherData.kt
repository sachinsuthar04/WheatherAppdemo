package com.sachin.weathear.rest.vo

data class WeatherData(
    var coord: Coord,
    var weather: java.util.List<Weather>,
    var base:String,
    var main:Main,
    var visibility:Int,
    var wind:Wind,
    var clouds:Clouds,
    var dt:Int,
    var sys:Sys,
    var id:Int,
    var name:String,
    var cod:Int

)

data class Coord(
    var lat: Double,
   var lon: Double
)

data class Clouds(
    var all: Int
)

data class Main(
    var temp:Double,
    var pressure:Int,
    var humidity:Int,
    var temp_min:Double,
    var temp_max:Double
)

data class Sys(

    var type:Int,
    var id:Int,
    var message:Double,
    var country:String,
    var sunrise:Int,
    var sunset:Int
)

data class Weather(
    var id:Int,
    var main:String,
    var description:String,
    var icon:String
)

data class Wind(

    var speed:Double,
    var deg:Int
)