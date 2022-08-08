package com.jeflette.dogbreedapplication.data.local.room

import androidx.room.*
import com.jeflette.dogbreedapplication.data.local.entity.Breed
import kotlinx.coroutines.flow.Flow

@Dao
interface DogsBreedDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertBreed(breeds: List<Breed>)

    @Query("SELECT * FROM breed_table")
    fun getAllBreeds(): Flow<List<Breed>>

    @Query("SELECT * FROM breed_table WHERE isFavorite = 1")
    suspend fun getBreedFavorite(): List<Breed>

    @Delete
    suspend fun deleteBreed(breed: Breed)

    @Update
    suspend fun updateBreed(breed: Breed)

}