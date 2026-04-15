package com.example.unscramble.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [GameEntity::class], version = 1, exportSchema = false)
abstract class GameRoomDb : RoomDatabase() {
    abstract fun gameDao(): GameDao
    companion object {
        @Volatile
        private var INSTANCE: GameRoomDb? = null
        fun getDatabase(context: Context): GameRoomDb {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context,
                    GameRoomDb::class.java,
                    "game_database"
                )
                    .build()
                    .also { INSTANCE = it }
            }
        }
    }
}