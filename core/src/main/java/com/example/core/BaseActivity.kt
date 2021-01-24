package com.example.core

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<TViewBinding : ViewDataBinding> : AppCompatActivity() {
    lateinit var binding: TViewBinding

    abstract val layoutId: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutId)
        binding.lifecycleOwner = this
    }
    fun setActionBar(toolbar: Toolbar) = setSupportActionBar(toolbar)

    fun setHomeIndicatorEnabled(show: Boolean) = supportActionBar?.setDisplayHomeAsUpEnabled(show)
}