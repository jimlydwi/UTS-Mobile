package com.example.unscramble.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface GameDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(game: GameEntity)

    @Query("SELECT * FROM game_table")
    suspend fun getAll(): List<GameEntity>
}