package com.sachin.weathear.base

import android.app.Application
import androidx.room.Room
import com.sachin.weathear.database.AppDatabase
import com.sachin.weathear.di.AppComponent
import com.sachin.weathear.di.DaggerAppComponent
import com.sachin.weathear.di.module.AppModule
import com.sachin.weathear.di.module.NetWorkModule

class MyApplication:Application() {

    open lateinit var appComponent: AppComponent

    companion object{
        lateinit var application: MyApplication
    }

    override fun onCreate() {
        super.onCreate()

        application = this

        appComponent = DaggerAppComponent.builder()
            .netWorkmodule(NetWorkModule)
            .appModule(AppModule(application, Room.databaseBuilder(this,
                AppDatabase::class.java, "MVVM_DEMO")
                .allowMainThreadQueries().build())).build()

        appComponent.inject(this)

    }
}