package com.example.featuredisplayjoke

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.core.ui.BaseFragment
import com.example.featuredisplayjoke.databinding.FragmentDisplayJokeBinding
import com.example.featuredisplayjoke.di.DisplayJokeComponentProvider
import javax.inject.Inject

class DisplayJokeFragment : BaseFragment<FragmentDisplayJokeBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_display_joke

    private val componentProvider: DisplayJokeComponentProvider
        get() = (baseActivity.application) as DisplayJokeComponentProvider


    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: DisplayJokeViewModel by viewModels { viewModelFactory }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        componentProvider.provideDisplayJokeComponent(this).inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
    }
}