package com.example.data.database.dao

import androidx.room.*
import com.example.data.database.entities.ExampleEntity

@Dao
interface ExampleDao {

    @Query("SELECT * FROM exampleentity")
    suspend fun getAllExamples(): List<ExampleEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addOrUpdateExample(exampleEntity: ExampleEntity)

    @Delete
    suspend fun deleteExample(exampleEntity:ExampleEntity)
}