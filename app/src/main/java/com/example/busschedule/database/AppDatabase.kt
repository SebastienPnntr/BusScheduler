package com.example.busschedule.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.busschedule.database.schedule.Schedule
import com.example.busschedule.database.schedule.ScheduleDAO

@Database(entities = arrayOf(Schedule::class), version = 1)
abstract class appDatabase: RoomDatabase(){
    abstract fun scheduleDao(): ScheduleDAO

    companion object{
        @Volatile
        private var INSTANCE: appDatabase? = null

        fun getDatabse(context: Context): appDatabase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context,
                    appDatabase::class.java,
                    "app_database")
                    .createFromAsset("database/bus_schedule.db")
                    .build()
                INSTANCE = instance

                instance
            }
        }
    }
}