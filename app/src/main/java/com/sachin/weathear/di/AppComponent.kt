package com.sachin.weathear.di

import com.sachin.weathear.ui.activity.MainActivity
import com.sachin.weathear.base.BaseActivity
import com.sachin.weathear.base.BaseViewModel
import com.sachin.weathear.base.MyApplication
import com.sachin.weathear.di.module.AppModule
import com.sachin.weathear.di.module.NetWorkModule
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [NetWorkModule::class, AppModule::class])
abstract class AppComponent {

    abstract fun inject(myApplication: MyApplication)
    abstract fun inject(mainActivity: MainActivity)
    abstract fun inject(baseActivity: BaseActivity)
    abstract fun inject(baseViewModel: BaseViewModel)

    @Component.Builder
    interface Builder {
        fun build(): AppComponent
        fun netWorkmodule(netWorkModule: NetWorkModule): Builder
        fun appModule(appModule: AppModule): Builder
    }

}