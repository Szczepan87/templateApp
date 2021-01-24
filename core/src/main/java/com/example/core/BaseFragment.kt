package com.example.core

import android.app.Activity
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<TViewBinding : ViewDataBinding> : Fragment() {

    private var _binding: TViewBinding? = null
    protected val binding: TViewBinding
        get() = _binding ?: throw IllegalStateException()

    abstract val layoutId: Int

    protected val baseActivity: BaseActivity<*>
        get() = activity as BaseActivity<*>

    protected open val hasLockedOrientation = false
    protected open val defaultScreenOrientation = ActivityInfo.SCREEN_ORIENTATION_SENSOR

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setScreenOrientation(true)

        _binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        setupActionBar()
    }

    protected open fun setupActionBar() = clearActionBar()

    private fun clearActionBar() {
        baseActivity.setSupportActionBar(null)
    }

    override fun onDestroyView() {
        setScreenOrientation(false)

        super.onDestroyView()
        _binding = null
    }

    private fun setScreenOrientation(lock: Boolean) {
        if (hasLockedOrientation) {
            val orientation = if (lock) {
                defaultScreenOrientation
            } else {
                ActivityInfo.SCREEN_ORIENTATION_SENSOR
            }
            requireActivity().requestedOrientation = orientation
        }
    }

    protected fun hideKeyboard(view: View? = null) {
        activity?.run {
            val inputMethodManager =
                getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager?
            (view ?: getView())?.run {
                inputMethodManager?.hideSoftInputFromWindow(this.windowToken, 0)
            }
        }
    }
}