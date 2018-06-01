package com.example.jcp.siriusxmtest.di

import com.example.jcp.siriusxmtest.data.DataRepository
import com.example.jcp.siriusxmtest.util.rx.SchedulerProvider
import dagger.Component
import javax.inject.Singleton

/**
 * Created by jacp on 5/23/2018.
 */
@Singleton
@Component(modules = arrayOf(DomainModule::class, RxModule::class))
interface MainComponent {
    fun dataRepository(): DataRepository
    fun schedulerProvider(): SchedulerProvider
}