package com.sachin.weathear.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @get:Query("SELECT * FROM User")
    val getAllUser:List<User>

    @Insert
    fun insertAll(vararg user: User)
}