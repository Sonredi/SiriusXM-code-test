package com.example.jcp.siriusxmtest.ui.main.di

import com.example.jcp.siriusxmtest.di.MainComponent
import com.example.jcp.siriusxmtest.di.scopes.PerView
import com.example.jcp.siriusxmtest.ui.main.MainActivity
import dagger.Component

/**
 * Created by jacp on 5/23/2018.
 */
@PerView
@Component(dependencies = arrayOf(MainComponent::class), modules = arrayOf(HomeModule::class))
interface HomeComponent {
    fun inject(mainActivity: MainActivity)
}