package com.manuflowers.funkosmarket.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.manuflowers.funkosmarket.R
import com.manuflowers.funkosmarket.application.FunkosMarketApp
import com.manuflowers.funkosmarket.ui.list.MainAdapter
import com.manuflowers.funkosmarket.ui.viewModel.MainViewModel
import com.manuflowers.funkosmarket.ui.viewModel.MainViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mainAdapter by lazy {
        MainAdapter()
    }

    private val viewModel: MainViewModel by lazy {
        val factory = MainViewModelFactory(FunkosMarketApp().repository)
        ViewModelProvider(this, factory).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecyclerView()
        subscribeData()
        viewModel.loadData()
    }

    private fun setupRecyclerView() {
        mainRecyclerView.adapter = mainAdapter
    }

    private fun subscribeData() {
        viewModel.funkosListLiveData.observe(this, Observer {
            mainAdapter.setData(it)
        })
    }
}