package com.example.crud_demo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.crud_demo.db.CustomerRepository

class CustomerViewModelFactory(private val repository: CustomerRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CustomerViewModel::class.java)){
            return CustomerViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }
}