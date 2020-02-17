package com.sachin.weathear.database

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class User(
    @field:PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val pass: String
)