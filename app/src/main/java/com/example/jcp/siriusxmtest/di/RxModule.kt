package com.example.jcp.siriusxmtest.di

import com.example.jcp.siriusxmtest.util.rx.AppSchedulerProvider
import com.example.jcp.siriusxmtest.util.rx.SchedulerProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by jacp on 5/23/2018.
 */
@Module
class RxModule {

    @Singleton
    @Provides
    fun createSchedulerProvider(): SchedulerProvider {
        return AppSchedulerProvider
    }
}