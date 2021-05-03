package com.example.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.database.dao.ExampleDao
import com.example.data.database.entities.ExampleEntity

@Database(entities = [ExampleEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun getExampleDao():ExampleDao
}