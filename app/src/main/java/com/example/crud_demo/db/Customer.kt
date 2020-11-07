package com.example.crud_demo.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

    @Entity(tableName = "customer_data_table")
data class Customer(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "customer_id")
    val id:Int,
    @ColumnInfo(name = "customer_name")
    val name:String,
    @ColumnInfo(name = "customer_email")
    val email:String) {
}