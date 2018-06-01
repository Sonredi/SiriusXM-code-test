package com.example.jcp.siriusxmtest.ui.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.databinding.ObservableArrayList
import com.example.jcp.siriusxmtest.base.BaseViewModel
import com.example.jcp.siriusxmtest.data.DataRepository
import com.example.jcp.siriusxmtest.data.entities.ApiResponse
import com.example.jcp.siriusxmtest.data.entities.Item
import com.example.jcp.siriusxmtest.util.AppLogger
import com.example.jcp.siriusxmtest.util.rx.SchedulerProvider
import javax.inject.Inject

/**
 * Created by jacp on 5/23/2018.
 */
class MainViewModel @Inject constructor(private val dataRepository: DataRepository,
                                        private val schedulerProvider: SchedulerProvider) : BaseViewModel(), MainContract.ViewModel {


    val questionDataList = ObservableArrayList<Item>()
    private val questionCardData: MutableLiveData<List<Item>> = MutableLiveData()
    private val error: MutableLiveData<String> = MutableLiveData()


    private val loadingData = MutableLiveData<Boolean>()
    val isLoadingData: LiveData<Boolean> = Transformations.map(loadingData, {it})

    private val loadingPage = MutableLiveData<Boolean>()
    val isLoadingPage: LiveData<Boolean> = Transformations.map(loadingPage, {it})


    var nextIndex: Int = 0
    var totalCount: Int = 0


    var initialized = false

    override fun loadInitialData(forceSync: Boolean){
        val mLoading = (loadingData.value ?: false) or (loadingPage.value ?: false)
        if((!initialized ||  forceSync) && !mLoading){
            nextIndex = 0
            totalCount = 0
            loadingData.value = true
            compositeDisposable.add(dataRepository.getCards(nextIndex)
                    .subscribeOn(schedulerProvider.computation())
                    .observeOn(schedulerProvider.ui())
                    .subscribe({onDataLoaded(it)}, {errorDownloading(it)}))
        }
    }

    fun onDataLoaded(response: ApiResponse){
        initialized = true
        questionDataList.clear()
        questionDataList.addAll(response.items)
        loadingData.value = false
        nextIndex += response.items.size
        totalCount = response.totalItems
    }

    override fun loadNextPage(){
        val mLoading = (loadingData.value ?: false) or (loadingPage.value ?: false)
        if(nextIndex < totalCount && !mLoading){
            loadingPage.value = true
            compositeDisposable.add(dataRepository.getCards(nextIndex)
                    .subscribeOn(schedulerProvider.computation())
                    .observeOn(schedulerProvider.ui())
                    .subscribe({onNextPage(it)}, {errorDownloading(it)}))
        }
    }

    fun onNextPage(response: ApiResponse){
        response.items.let {
            questionDataList.addAll(it)
            nextIndex += it.size
        }
        loadingPage.value = false
        totalCount = response.totalItems
    }

    private fun errorDownloading(it: Throwable) {
        questionCardData.value = emptyList()
        error.value = "Couldn't download data!"
        AppLogger.d(it.localizedMessage)
    }

    override fun getErrorMessage(): MutableLiveData<String> {
        return error
    }

    override fun getLoadingDataState(): LiveData<Boolean> {
        return isLoadingData
    }

    override fun getLoadingPageState(): LiveData<Boolean> {
        return isLoadingPage
    }
}