// Par Sebastien Pannatier
package com.example.busschedule

import android.app.Application
import com.example.busschedule.database.appDatabase

class BusScheduleApplication : Application() {
    val database: appDatabase by lazy { appDatabase.getDatabse(this) }
}