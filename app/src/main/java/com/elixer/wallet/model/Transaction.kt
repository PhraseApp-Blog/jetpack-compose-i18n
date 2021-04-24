package com.elixer.wallet.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recipes")
data class Transaction(

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "emoji")
    var emojiCode: String,

    @ColumnInfo(name = "amount")
    var amount: Int,

    @ColumnInfo(name = "date_added")
    var dateAdded: Long,

    @ColumnInfo(name = "type")
    var type: String,

    )

enum class TYPE {
    EXPENSE, INCOME

}