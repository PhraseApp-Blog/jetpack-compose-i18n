package com.elixer.wallet.cache.database


import androidx.room.Database
import androidx.room.RoomDatabase
import com.elixer.wallet.cache.RecipeDao
import com.elixer.wallet.model.Transaction

@Database(entities = [Transaction::class ], version = 2)
abstract class AppDatabase: RoomDatabase() {

    abstract fun recipeDao(): RecipeDao

    companion object{
        val DATABASE_NAME: String = "recipe_db"
    }


}