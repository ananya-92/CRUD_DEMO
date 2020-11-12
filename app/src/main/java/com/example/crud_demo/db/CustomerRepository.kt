package com.example.crud_demo.db

class CustomerRepository(private val dao: CustomerDAO)
{

    val customer = dao.getAllCustomers()

    suspend fun insert(customer: Customer)
    {
        dao.insertCustomer(customer)
    }

    suspend fun update(customer: Customer)
    {
        dao.updateCustomer(customer)
    }

    suspend fun delete(customer: Customer){
        dao.deleteCustomer(customer)
    }
    
    suspend fun deleteAll(){
        dao.deleteAll()
    }
}