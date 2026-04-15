package com.example.unscramble.data

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

interface GameDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(game: GameEntity)

    @Query("SELECT * FROM game_table")
    suspend fun getAll(): List<GameEntity>
}