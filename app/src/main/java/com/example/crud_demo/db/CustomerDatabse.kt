package com.example.crud_demo.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Customer::class],version = 1)
abstract class CustomerDatabse: RoomDatabase {
    abstract  val customerDAO:CustomerDAO
    @Volatile
    companion object{
        private var INSTANCE : CustomerDatabse? = null
        fun getInstance(context: Context):CustomerDatabse{
            synchronized(lock = this){
                var instance:CustomerDatabse? = INSTANCE
                if (instance==null)
                {
                    instance = Room.databaseBuilder(context.applicationContext,
                        CustomerDatabse::class.java,
                        "customer_data_database").build()
                }
                return instance
            }
        }
    }
}