package com.elixer.wallet.presentation.ui.edit_transaction

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elixer.wallet.model.TYPE
import com.elixer.wallet.model.Transaction
import com.elixer.wallet.presentation.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class EditTransactionViewModel @Inject constructor(private val repository: Repository) :
    ViewModel() {

    val title: MutableState<String> = mutableStateOf("")
    val amount: MutableState<String> = mutableStateOf("")
    val emoji: MutableState<String> = mutableStateOf("💰")

    fun setTitle(title: String) {
        this.title.value = title.capitalize()
    }

    fun setAmount(amount: String) {
//        val number = amount.toIntOrNull()
        this.amount.value = amount
    }

    fun setEmoji(emoji: String) {
        this.emoji.value = emoji
    }

    fun addExpense() {
        viewModelScope.launch {
            repository.addToDatabase(
                Transaction(
                    title = title.value, amount = (amount.value.toInt()), emojiCode = emoji.value,
                    dateAdded = System.currentTimeMillis(), type = TYPE.EXPENSE.toString()
                )
            )
        }
    }

    fun addIncome() {
        viewModelScope.launch {
            repository.addToDatabase(
                Transaction(
                    title = title.value, amount = (amount.value.toInt()), emojiCode = emoji.value,
                    dateAdded = System.currentTimeMillis() / 1000, type = TYPE.INCOME.toString()
                )
            )
        }
    }


}
















