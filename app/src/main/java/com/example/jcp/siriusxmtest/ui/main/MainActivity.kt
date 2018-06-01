package com.example.jcp.siriusxmtest.ui.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast
import com.example.jcp.siriusxmtest.BR
import com.example.jcp.siriusxmtest.R
import com.example.jcp.siriusxmtest.base.BaseActivity
import com.example.jcp.siriusxmtest.databinding.ActivityMainBinding
import com.example.jcp.siriusxmtest.di.MainComponent
import com.example.jcp.siriusxmtest.ui.card.CardAdapter
import com.example.jcp.siriusxmtest.ui.main.di.DaggerHomeComponent
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject
import android.util.Log
import android.view.Menu
import android.view.MenuItem


class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(), MainContract.View {

    companion object {
        private const val TAG = "TAG_"
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var cardAdapter: CardAdapter

    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        subscribeToLiveData()
        viewDataBinding.aMainRecycler.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val layoutManager = recyclerView!!.layoutManager
                val totalItemCount = layoutManager.getItemCount()
                val lastVisibleItemPosition = (layoutManager as LinearLayoutManager).findLastVisibleItemPosition()

                Log.d(TAG, "item Count $totalItemCount")
                if ( lastVisibleItemPosition == totalItemCount - 1) {
                    viewModel.loadNextPage()
                    Log.d(TAG, "Loading next pag $lastVisibleItemPosition")
                }

            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_options, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            R.id.refresh_action -> {
                viewModel.loadInitialData(true)
                return true
            }
        }
        return false
    }

    override fun onStart() {
        super.onStart()
        viewModel.loadInitialData(false)
    }

    override fun setup() {
        viewDataBinding.aMainRecycler.adapter = cardAdapter
        viewDataBinding.aMainRecycler.layoutManager = LinearLayoutManager(this)
        viewDataBinding.aMainRecycler.itemAnimator = DefaultItemAnimator()
        viewDataBinding.aMainRecycler.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
    }


    override fun injectDependencies(mainComponent: MainComponent?) {
        DaggerHomeComponent.builder()
                .mainComponent(mainComponent)
                .build()
                .inject(this)
    }

    override fun setViewModel() {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)
    }

    //TODO: remove
    val showToast: (String) -> Unit = {it -> Toast.makeText(this,it,Toast.LENGTH_SHORT).show()}

    //Todo optimize call to reuse only one method and send nextPage parameter
    override fun subscribeToLiveData() {
        viewModel.getLoadingDataState()
                .observe(this, Observer {if(it == true) showProgress() else hideProgress() })

        viewModel.getLoadingPageState()
                .observe(this, Observer { showToast("Loading Page") })


        viewModel.getErrorMessage()
                .observe(this, Observer { showError(it) })
    }

    override fun showError(error: String?) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }

    override fun showProgress() {
        a_main_progress.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        a_main_progress.visibility = View.INVISIBLE
    }
}