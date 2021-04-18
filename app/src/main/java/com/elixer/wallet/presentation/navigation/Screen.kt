package com.elixer.wallet.presentation.navigation

sealed class Screen(val route: String, ){

    object Dashboard: Screen("dashboard")

    object AddTransaction: Screen("addTransaction")
}