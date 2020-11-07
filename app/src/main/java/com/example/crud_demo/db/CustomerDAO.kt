package com.example.crud_demo.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface CustomerDAO {
   // @Insert(onConflict = OnConflictStrategy.REPLACE)
    @Insert
    suspend fun insertCustomer(customer: Customer):Long

   /* @Insert
    suspend fun insertCustomer2(customer: Customer):Long

    @Insert
    suspend fun insertCustomers(customer1: Customer, customer2: Customer, customer3: Customer):List<Long>

    @Insert
    suspend fun insertCustomers(customers: List<Customer>):List<Long>

    @Insert
    suspend fun insertCustomers2(customer: Customer, customers: List<Customer>):List<Long>
*/

    @Update
    suspend fun updateCustomer(customer: Customer)

    @Delete
    suspend fun deleteCustomer(customer: Customer)

    @Query("DELETE FROM customer_data_table")
    suspend fun deleteAll()

    @Query("SELECT * FROM customer_data_table")
    suspend fun getAllCustomers(): LiveData<List<Customer>>
}