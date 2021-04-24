package com.elixer.wallet.presentation.ui.dashboard

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.elixer.wallet.model.Transaction
import com.elixer.wallet.presentation.navigation.Screen
import com.elixer.wallet.presentation.theme.WalletTheme
import kotlinx.coroutines.ExperimentalCoroutinesApi


@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@ExperimentalCoroutinesApi
@ExperimentalMaterialApi
@Composable
fun DashboardScreen(
    viewModel: DashboardViewModel,
    onNavigateToEditTransactionScreen: (String) -> Unit,
) {

    var expanded = remember { mutableStateOf(false) }
    val transactions = viewModel.transactions.value
    val expense = viewModel.netExpence.value
    val income = viewModel.netIncome.value
    val balance = viewModel.balance.value

    fun navigateToAddTransaction() {
        val route = Screen.EditTransaction.route
        onNavigateToEditTransactionScreen(route)
    }

    WalletTheme() {
        Scaffold(
            floatingActionButton = {
                FloatingActionButton(
                    onClick = { navigateToAddTransaction() },
                    backgroundColor = MaterialTheme.colors.primary,
                ) { Icon(Icons.Filled.Add, "Add transaction") }
            }) {

            Surface(modifier = Modifier.fillMaxSize()) {
                Column(modifier = Modifier.padding(horizontal = 15.dp)) {

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(text = "Hello, Jane", style = MaterialTheme.typography.h3)
                        Spacer(modifier = Modifier.weight(1f))

                        Column() {
                            IconButton(onClick = { expanded.value = true }) {
                                Icon(
                                    Icons.Filled.Settings,
                                    "Settings",
                                    Modifier.then(Modifier.size(40.dp)),
                                    tint = Color.White
                                )
                            }
                            Dropdown(expanded.value, onDismiss = { expanded.value = it })
                        }

                    }

                    Spacer(modifier = Modifier.padding(top = 20.dp))
                    WalletSummary(balance = balance, expense, income = income)
                    Spacer(modifier = Modifier.padding(top = 10.dp))
                    Text(text = "Transactions", style = MaterialTheme.typography.h5)
                    Spacer(modifier = Modifier.padding(top = 10.dp))
                    transactionList(transactions = transactions)
                }
            }
        }
    }
}

@Composable
fun Dropdown(isExpanded: Boolean, onDismiss: (Boolean) -> Unit) {
    DropdownMenu(
        expanded = isExpanded,
        onDismissRequest = { onDismiss(false) }
    ) {
        DropdownMenuItem(onClick = { /* Handle refresh! */ }) {
            Text("English")
        }
        DropdownMenuItem(onClick = { /* Handle settings! */ }) {
            Text("French")
        }
        Divider()
        DropdownMenuItem(onClick = { /* Handle send feedback! */ }) {
            Text("Default")
        }
    }
}

@Composable
fun transactionList(transactions: List<Transaction>) {

    LazyColumn(verticalArrangement = Arrangement.spacedBy(5.dp)) {
        itemsIndexed(items = transactions) { index, transaction ->
            TransactionItem(
                transaction = transaction
            )
            if (index == transactions.lastIndex) {
                Spacer(modifier = Modifier.padding(top = 70.dp))
            } else {
                Divider(color = Color(0x94646464), thickness = 0.8.dp)
            }
        }
    }
}

@Composable
fun WalletSummary(balance: String, expense: String, income: String) {
    Card(shape = RoundedCornerShape(15.dp)) {
        val gradient = Brush.verticalGradient(
            listOf(
                Color(0xFF9456EE), Color(0xFF8D4BEE),
                Color(0xFF6211DA), Color(0xFF540EBB), Color(0xFF420A96)
            )
        )
        val modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
        Box(
            modifier = Modifier
                .background(gradient)
                .then(modifier)
        ) {
            Column(
                Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "BALANCE",
                    style = MaterialTheme.typography.overline,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "$ $balance",
                    style = MaterialTheme.typography.h3,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "TOTAL INCOME",
                    style = MaterialTheme.typography.overline,
                    modifier = Modifier.align(Alignment.End)
                )
                Text(
                    text = income,
                    style = MaterialTheme.typography.h4,
                    modifier = Modifier.align(Alignment.End)
                )
                Text(
                    text = "TOTAL EXPENSE",
                    style = MaterialTheme.typography.overline,
                    modifier = Modifier.align(Alignment.End)
                )
                Text(
                    text = expense,
                    style = MaterialTheme.typography.h4,
                    modifier = Modifier.align(Alignment.End)
                )
            }
        }
    }
}