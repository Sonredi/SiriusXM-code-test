package com.example.jcp.siriusxmtest.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.jcp.siriusxmtest.SiriusXm
import com.example.jcp.siriusxmtest.di.MainComponent

abstract class BaseActivity<T : ViewDataBinding, V : BaseViewModel> : AppCompatActivity() {

  protected abstract val layoutId: Int
  protected abstract val bindingVariable: Int

  protected lateinit var viewModel: V
  protected lateinit var viewDataBinding: T

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(layoutId)
    injectDependencies((application as SiriusXm).mainComponent)
    setViewModel()
    viewDataBinding = DataBindingUtil.setContentView<T>(this, layoutId)
    viewDataBinding.setVariable(bindingVariable, viewModel)
    setup()
    viewDataBinding.executePendingBindings()
  }

  abstract fun setup()
  abstract fun injectDependencies(mainComponent: MainComponent?)
  abstract fun setViewModel()
}