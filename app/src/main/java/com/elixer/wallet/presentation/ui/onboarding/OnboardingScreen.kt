//package com.elixer.wallet.presentation.ui.onboarding
//
//import android.util.Log
//import androidx.compose.foundation.ExperimentalFoundationApi
//import androidx.compose.foundation.layout.Box
//import androidx.compose.material.ExperimentalMaterialApi
//import androidx.compose.material.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.livedata.observeAsState
//import androidx.compose.ui.ExperimentalComposeUiApi
//import androidx.navigation.NavController
//import com.elixer.wallet.presentation.theme.WalletTheme
//import kotlinx.coroutines.ExperimentalCoroutinesApi
//
//@ExperimentalFoundationApi
//@ExperimentalComposeUiApi
//@ExperimentalCoroutinesApi
//@ExperimentalMaterialApi
//@Composable
//fun DashboardScreen(viewModel: DashboardViewModel, navController: NavController) {
//
//    val dogs = viewModel.transactions.observeAsState()
//
//    WalletTheme() {
//        Text("DAhsboaed")
//        Log.e("dashboard","dashboard")
//        Box() {
//            Text("DAhsboaed")
////            Column(modifier = Modifier.padding(bottom = 10.dp)) {
////                TopAppBar(title = { Text(text = "Dog List") })
////                LazyVerticalGrid(cells = GridCells.Fixed(2)) {
//////                    items(dogs) { dog ->
//////
//////                    }
////                }
////            }
////
////            Column() {
////                Spacer(Modifier.weight(1f))
////                Button(onClick = { }, modifier = Modifier.fillMaxWidth()) {
////                    Text(text = "Load More")
////
////                }
////            }
//        }
//
//    }
//}