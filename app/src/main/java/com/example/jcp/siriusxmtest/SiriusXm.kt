package com.example.jcp.siriusxmtest;

import android.app.Application;
import com.example.jcp.siriusxmtest.di.DaggerMainComponent
import com.example.jcp.siriusxmtest.di.DomainModule
import com.example.jcp.siriusxmtest.di.MainComponent
import com.example.jcp.siriusxmtest.di.RxModule
import com.example.jcp.siriusxmtest.util.AppLogger

/**
 * Created by jacp on 5/23/2018.
 */
class SiriusXm : Application() {

    var mainComponent: MainComponent? = null
        private set

    override fun onCreate() {
        super.onCreate()

        AppLogger.init()

        mainComponent = DaggerMainComponent.builder()
                .domainModule(DomainModule())
                .rxModule(RxModule())
                .build()
    }
}