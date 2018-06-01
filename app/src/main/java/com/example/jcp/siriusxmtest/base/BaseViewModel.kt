package com.example.jcp.siriusxmtest.base

import android.arch.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel : ViewModel() {

  protected val compositeDisposable = CompositeDisposable()

  override fun onCleared() {
    super.onCleared()
    compositeDisposable.dispose()
  }
}