package com.elixer.wallet.presentation.ui.dashboard

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elixer.wallet.model.TYPE
import com.elixer.wallet.model.Transaction
import com.elixer.wallet.presentation.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    init {
        collectFlows()
    }

    val balance: MutableState<String> = mutableStateOf("0")
    val netExpence: MutableState<String> = mutableStateOf("0")
    val netIncome: MutableState<String> = mutableStateOf("0")

    val transactions = mutableStateOf(listOf<Transaction>())


    private fun collectFlows() {
        viewModelScope.launch {
            repository.getTransactions().collect {
                var expense = 0
                var income = 0

                transactions.value = it
                it.forEach {

                    when(it.type){
                        TYPE.INCOME.toString() -> {
                            income = income + it.amount
                        }
                        TYPE.EXPENSE.toString() -> {
                            expense = expense +  it.amount
                        }
                    }
                }
                netExpence.value = "-$expense"
                netIncome.value = "+$income"
                balance.value = (income-expense).toString()

            }
        }
    }


}





















