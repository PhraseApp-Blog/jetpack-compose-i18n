package com.elixer.wallet.presentation.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.elixer.wallet.model.Transaction
import com.elixer.wallet.presentation.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    private val _transactions = MutableLiveData(listOf<Transaction>())
    val transactions: LiveData<List<Transaction>> = repository.getTransactions().asLiveData()


}





















