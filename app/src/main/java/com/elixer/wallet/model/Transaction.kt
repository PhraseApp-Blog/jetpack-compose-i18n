package com.elixer.wallet.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recipes")
data class Transaction(

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    var id: Int,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "rating")
    var rating: Int,

    @ColumnInfo(name = "emoji")
    var emojiCode: String,

    @ColumnInfo(name = "date_added")
    var dateAdded: Long,

    )