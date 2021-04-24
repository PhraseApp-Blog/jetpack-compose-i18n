package com.elixer.wallet.presentation.ui.edit_transaction

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.elixer.wallet.presentation.navigation.Screen
import com.elixer.wallet.presentation.theme.WalletTheme
import com.elixer.wallet.presentation.ui.util.Util
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@ExperimentalCoroutinesApi
@ExperimentalMaterialApi
@Composable
fun EditTransactionScreen(
    editTransactionViewModel: EditTransactionViewModel,
    navController: NavController,
) {

    val title = editTransactionViewModel.title.value
    val amount = editTransactionViewModel.amount.value
    val emoji = editTransactionViewModel.emoji.value
    val keyboardController = LocalSoftwareKeyboardController.current

    fun navigateToDashboard() {
        val route = Screen.Dashboard.route
        navController.navigate(route) {
            launchSingleTop = true
        }
    }


    WalletTheme() {
        Surface(modifier = Modifier.fillMaxSize()) {
            Box() {
                var emojis = Util.getEmojis()

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(horizontal = 10.dp)
                ) {
                    Spacer(modifier = Modifier.height(10.dp))
                    Box(Modifier.fillMaxWidth()) {
                        Canvas(modifier = Modifier
                            .size(120.dp)
                            .align(Alignment.Center), onDraw = {
                            drawCircle(color =  Color(0xFF302F2F))
                        })
                        Text(
                            text = emoji,
                            fontSize = 60.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                    Spacer(modifier = Modifier.height(30.dp))
                    OutlinedTextField(
                        value = title,
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                        onValueChange = { editTransactionViewModel.setTitle(it) },
                        textStyle = TextStyle(
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                        ),
                        label = { Text("Title") },
                        maxLines = 1,
                        keyboardActions = KeyboardActions(
                            onDone = { keyboardController?.hide() })
                    )

                    OutlinedTextField(
                        value = amount,
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                        onValueChange = { editTransactionViewModel.setAmount(it.toString()) },
                        textStyle = TextStyle(
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                        ),
                        label = { Text("Amount") },
                        maxLines = 1,
                        keyboardActions = KeyboardActions(
                            onDone = { keyboardController?.hide() })


                    )
                    Spacer(modifier = Modifier.height(50.dp))
                    LazyVerticalGrid(
                        cells = GridCells.Fixed(4),
                        modifier = Modifier
                            .fillMaxHeight()
                            .padding(bottom = 80.dp)
                    ) {
                        items(emojis) { emoji ->
                            Text(
                                emoji,
                                fontSize = 30.sp,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.clickable(onClick = {
                                    editTransactionViewModel.setEmoji(emoji)
                                })
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(15.dp))
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Spacer(modifier = Modifier.weight(1f))
                    Row(
                        modifier = Modifier
                            .padding(20.dp)
                            .fillMaxWidth()
                    ) {
                        Button(
                            onClick = {
                                editTransactionViewModel.addIncome()
                                navigateToDashboard()

                            },
                            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF499118))
                        ) {
                            Text(
                                text = "Add Income",
                                style = MaterialTheme.typography.h6,
                                textAlign = TextAlign.Center
                            )
                        }
                        Spacer(modifier = Modifier.weight(1f))
                        Button(
                            onClick = {
                                editTransactionViewModel.addExpense()
                                navigateToDashboard()
                            },
                            colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.onError)
                        ) {
                            Text(
                                text = "Add Expense",
                                style = MaterialTheme.typography.h6,
                                textAlign = TextAlign.Center
                            )
                        }
                    }

                }
            }
        }
    }
}
