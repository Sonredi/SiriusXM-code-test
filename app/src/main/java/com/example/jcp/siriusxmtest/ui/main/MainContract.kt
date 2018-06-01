package com.example.jcp.siriusxmtest.ui.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.example.jcp.siriusxmtest.data.entities.Item

/**
 * Created by jacp on 5/23/2018.
 */
interface MainContract {
    interface View {
        fun subscribeToLiveData()
        fun showError(error: String?)
        fun showProgress()
        fun hideProgress()
    }

    interface ViewModel {
        fun getLoadingPageState(): LiveData<Boolean>
        fun getLoadingDataState(): LiveData<Boolean>
        fun getErrorMessage(): MutableLiveData<String>
        fun loadInitialData(forceSync: Boolean)
        fun loadNextPage()
    }
}