package com.elixer.wallet.presentation.ui.dashboard

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
    displayName: String
) {

    val transactions = viewModel.transactions.value
    val expense = viewModel.netExpence.value
    val income = viewModel.netIncome.value
    val balance = viewModel.balance.value

    fun navigateToAddTransaction() {
        val route = Screen.EditTransaction.route
        onNavigateToEditTransactionScreen(route)
    }

    WalletTheme() {
        Scaffold(floatingActionButton = { floatingButton { navigateToAddTransaction() } }) {
            Surface(modifier = Modifier.fillMaxSize()) {
                Column(
                    modifier = Modifier
                        .padding(horizontal = 15.dp)
                ) {

                    Text(
                        text = "Hello,Joe",
                        style = MaterialTheme.typography.h3,
                        modifier = Modifier.padding(5.dp)
                    )

                    WalletSummary(balance = balance, expense, income = income)
                    verticalSpacing()
                    Text(
                        text = "Transactions",
                        style = MaterialTheme.typography.h5
                    )
                    verticalSpacing()
                    transactionList(transactions = transactions)
                }
            }
        }
    }
}


@Composable
fun verticalSpacing() {
    Spacer(modifier = Modifier.padding(top = 20.dp))
}

@ExperimentalFoundationApi
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
fun floatingButton(onClick: () -> Unit) {

    FloatingActionButton(
        onClick = onClick,
        backgroundColor = MaterialTheme.colors.primary,
    ) { Icon(Icons.Filled.Add, "Add transaction") }
}
