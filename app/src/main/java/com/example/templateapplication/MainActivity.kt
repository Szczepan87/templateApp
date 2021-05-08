package com.example.templateapplication

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.core.ui.BaseActivity
import com.example.templateapplication.databinding.ActivityMainBinding
import com.example.templateapplication.di.main.MainComponentProvider
import javax.inject.Inject

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override val layoutId: Int
        get() = R.layout.activity_main

    private val componentProvider: MainComponentProvider
        get() = application as MainComponentProvider

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: MainViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        componentProvider.provideMainComponent(this).inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
        componentProvider.clearMainComponent()
    }
}