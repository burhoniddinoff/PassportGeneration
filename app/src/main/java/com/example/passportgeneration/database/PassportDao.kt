package com.example.passportgeneration.database

import androidx.room.*

@Dao
interface PassportDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun savePassport(entity: Entity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updatePassport(entity: Entity)

    @Delete
    fun deletePassport(entity: Entity)

    @Query("SELECT * FROM PassportTable ORDER BY id DESC")
    fun getAllPassports(): List<Entity>

    @Query("DELETE FROM PassportTable")
    fun deleteAllPassports()
}