package com.example.databaseapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [(Player::class)], version = 1)
abstract class PlayerRoomDataBase : RoomDatabase() {
    abstract fun getPlayerDao(): PlayerDao

    companion object{
        private var INSTANCE: PlayerRoomDataBase? = null

        fun getInstance(context: Context) : PlayerRoomDataBase{
            synchronized(this){
                var instance = INSTANCE
                if(instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        PlayerRoomDataBase::class.java,
                        "player_database"
                    ).fallbackToDestructiveMigration().build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}