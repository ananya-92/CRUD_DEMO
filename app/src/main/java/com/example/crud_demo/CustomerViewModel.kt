package com.example.crud_demo

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.crud_demo.db.Customer
import com.example.crud_demo.db.CustomerRepository
import kotlinx.coroutines.launch

class CustomerViewModel(private val repository:CustomerRepository): ViewModel(), Observable {

    val customer = repository.customer

    @Bindable
    val inputName = MutableLiveData<String>()
    @Bindable
    val inputEmail = MutableLiveData<String>()

    @Bindable
    val saveOrUpdateButtonText = MutableLiveData<String>()

    @Bindable
    val clearAllOrDeleteButton = MutableLiveData<String>()

    init {
        saveOrUpdateButtonText.value = "Save"
        clearAllOrDeleteButton.value = "Clear All"
    }

    fun saveOrUpdate(){
    val name:String = inputName.value!!
        val email:String = inputEmail.value!!
        insert(Customer(0,name,email))
        inputName.value = null
        inputEmail.value = null
    }

    fun clearAllOrDelete(){
        clearAll()
    }

    fun insert(customer: Customer){
        viewModelScope.launch {
            repository.insert(customer)
        }
    }

    fun update(customer: Customer){
        viewModelScope.launch {
            repository.update(customer)
        }
    }

    fun delete(customer: Customer){
        viewModelScope.launch {
            repository.delete(customer)
        }
    }

    fun clearAll(){
        viewModelScope.launch {
            repository.deleteAll()
        }
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

}
