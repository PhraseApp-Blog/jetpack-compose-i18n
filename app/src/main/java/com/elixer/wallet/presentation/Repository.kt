package com.elixer.wallet.presentation

import com.elixer.wallet.cache.RecipeDao
import com.elixer.wallet.model.Transaction
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(val dogDao: RecipeDao) {

    suspend fun addToDatabase(transaction: Transaction) {
        dogDao.insertTransaction(transaction)

    }

    fun getTransactions(): Flow<List<Transaction>> {
        return dogDao.getTransactions() // Get searched dogs from Room Database
    }
}