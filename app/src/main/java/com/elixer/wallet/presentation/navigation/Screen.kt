package com.elixer.wallet.presentation.navigation

sealed class Screen(val route: String, ){

    object Dashboard: Screen("dashboard")

    object EditTransaction: Screen("editTransaction")

    object AddTransaction: Screen("addTransaction")

    object OnBoarding: Screen("onBoarding")
}