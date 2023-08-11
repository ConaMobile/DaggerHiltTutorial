package com.conamobile.daggerhilttutorial.mvvm.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "myTable")
data class DatabaseModel(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    val name: String? = null,
)