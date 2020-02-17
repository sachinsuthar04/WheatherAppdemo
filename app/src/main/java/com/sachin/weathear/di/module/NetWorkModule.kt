package com.sachin.weathear.di.module

import com.sachin.weathear.rest.ApiInterface
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Named

@Module
@Suppress("unused")
object NetWorkModule {

    @Provides
    internal fun providerApiInterfaceBase(@Named("base") retrofit: Retrofit): ApiInterface {
        return retrofit.create(ApiInterface::class.java)
    }

    @Provides
    @Named("base")
    internal fun providerRetrofitInterface(): Retrofit {

        return Retrofit.Builder().baseUrl("http://api.openweathermap.org/data/2.5/")
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .build()
    }
}