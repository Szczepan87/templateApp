package com.example.templateapplication.navigators

import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.core.navigators.BaseActivityNavigator
import com.example.navigation.MainNavigator
import com.example.templateapplication.R
import javax.inject.Inject

class MainNavigatorImpl @Inject constructor(
    private val activity: AppCompatActivity
) : BaseActivityNavigator(), MainNavigator {

    override val navController: NavController
        get() = activity.findNavController(R.id.navContainerMain)

    override fun navigateBack() {
        popBackStack()
    }
}