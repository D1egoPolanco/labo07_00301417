package com.example.labo07_00301417.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import java.security.AccessControlContext

@Database(entities = [Githubrepo::class], version = 1, exportSchema = false)
public abstract class RoomDatabase : RoomDatabase(){
    abstract fun repoDao(): githubDAO

    companion object {
        private var Instance: RoomDatabase? = null

        fun getInstance (Appcontext: Context):RoomDatabase{
            val tempInstance = Instance
            if (tempInstance !=null) return tempInstance
            synchronized(this){
            val instance = Room
                .databaseBuilder(Appcontext, RoomDatabase::class.java,"RepoDB")
                .build()
                Instance = instance
                return instance
            }
        }
    }
}