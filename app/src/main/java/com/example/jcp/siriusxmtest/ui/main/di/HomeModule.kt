package com.example.jcp.siriusxmtest.ui.main.di

import android.arch.lifecycle.ViewModelProvider
import com.example.jcp.siriusxmtest.di.scopes.PerView
import com.example.jcp.siriusxmtest.ui.card.CardAdapter
import com.example.jcp.siriusxmtest.ui.main.MainViewModel
import com.example.jcp.siriusxmtest.util.ViewModelFactory
import dagger.Module
import dagger.Provides

/**
 * Created by jacp on 5/23/2018.
 */
@Module

class HomeModule {

    @PerView
    @Provides
    fun createViewModelFactory(mainViewModel: MainViewModel): ViewModelProvider.Factory {
        return ViewModelFactory(mainViewModel)
    }

    @PerView
    @Provides
    fun createCardAdapter(): CardAdapter {
        return CardAdapter(mutableListOf())
    }
}