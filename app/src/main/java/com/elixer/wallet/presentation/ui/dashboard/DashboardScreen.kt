package com.elixer.wallet.presentation.ui.dashboard

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

import com.elixer.wallet.R
import com.elixer.wallet.presentation.theme.WalletTheme
import kotlinx.coroutines.ExperimentalCoroutinesApi


@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@ExperimentalCoroutinesApi
@ExperimentalMaterialApi
@Composable
fun DashboardScreen(viewModel: DashboardViewModel, navController: NavController) {

    val dogs = viewModel.transactions.observeAsState()

    WalletTheme() {
        
        Box(){
            Surface(color = Color.White, modifier = Modifier.fillMaxSize()) {
                
            }

            Surface(color = Color.DarkGray, modifier = Modifier
                .height(600.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(30.dp).copy(topStart = ZeroCornerSize,topEnd = ZeroCornerSize)) {

                Column() {
                    Image(
                        painter = painterResource(R.drawable.header),
                        contentDescription = null
                    )
                }

            }
            
        }
        Text("DAhsboaed")
        Log.e("dashboard","dashboard")
        

    }
}