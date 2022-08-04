package com.jeflette.dogbreedapplication.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.jeflette.dogbreedapplication.data.local.entity.Breed
import com.jeflette.dogbreedapplication.util.Converter

@Database(entities = [Breed::class], version = 1, exportSchema = false)
@TypeConverters(Converter::class)
abstract class DogsDatabase : RoomDatabase() {
    abstract fun breedDao(): DogsBreedDao
}