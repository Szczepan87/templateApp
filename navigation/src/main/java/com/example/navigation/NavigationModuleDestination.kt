package com.example.navigation

sealed class NavigationModuleDestination {
    object BaseModuleDestination : NavigationModuleDestination()
    // add classes for navigation with arguments like: NewFlow(val argument: String): NavigationFlow()
}
