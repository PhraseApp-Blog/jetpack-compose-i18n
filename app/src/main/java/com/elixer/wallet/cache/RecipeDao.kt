package com.elixer.wallet.cache

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.elixer.wallet.model.Transaction
import kotlinx.coroutines.flow.Flow


@Dao
interface RecipeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTransaction(recipe: Transaction): Long

    @Query("SELECT * FROM recipes")
    fun getTransactions(): Flow<List<Transaction>>

    @Query("SELECT * FROM recipes")
    fun getTotalIncome(): Flow<List<Transaction>>

    @Query("SELECT * FROM recipes WHERE type = 'EXPENSE' ")
    fun getTotalExpenditure(): Flow<List<Transaction>>

}