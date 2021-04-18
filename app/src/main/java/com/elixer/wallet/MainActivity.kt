package com.elixer.wallet

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.HiltViewModelFactory
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.elixer.wallet.presentation.navigation.Screen
import com.elixer.wallet.presentation.theme.WalletTheme
import com.elixer.wallet.presentation.ui.dashboard.DashboardScreen
import com.elixer.wallet.presentation.ui.dashboard.DashboardViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@ExperimentalComposeUiApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterialApi::class)
    @ExperimentalComposeUiApi
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WalletTheme() {
                Log.e("MainActivity","MainActivity")
                setContent {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = Screen.Dashboard.route) {
//                        composable(route = Screen.Dashboard.route,) { navBackStackEntry ->
//                            val factory =
//                                HiltViewModelFactory(LocalContext.current, navBackStackEntry)
//                            val viewModel = viewModel<AddTrasactionViewModel>("DogDetailViewModel", factory)
//                            navBackStackEntry.arguments?.getString("dog")?.let { json ->
////                                val dog = Gson().fromJson(json, Dog::class.java)
//                                AddTransactionScreen(
//                                    viewModel = viewModel,
//                                )
//                            }
//
//                        }

                        composable(
                            route = Screen.Dashboard.route
                        ) { navBackStackEntry ->
                            val factory =
                                HiltViewModelFactory(LocalContext.current, navBackStackEntry)
                            val viewModel: DashboardViewModel =
                                viewModel("DogListViewModel", factory)
                            DashboardScreen(
                                viewModel = viewModel,
                                navController = navController,
                            )
                        }


                    }

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    WalletTheme {
        Greeting("Android")
    }
}