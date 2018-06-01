package com.example.jcp.siriusxmtest.util

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

class ViewModelFactory<V>(private val viewModel: V) : ViewModelProvider.Factory {

  override fun <T : ViewModel> create(modelClass: Class<T>): T {
    return viewModel as T
  }
}
