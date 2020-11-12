package com.example.crud_demo

import android.os.Bundle
import android.util.Log
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.crud_demo.databinding.ActivityMainBinding
import com.example.crud_demo.db.Customer
import com.example.crud_demo.db.CustomerDAO
import com.example.crud_demo.db.CustomerDatabse
import com.example.crud_demo.db.CustomerRepository

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var customerViewModel: CustomerViewModel
    override fun onCreate(savedInstanceState: Bundle?) 
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        val dao:CustomerDAO = CustomerDatabse.getInstance(application).customerDAO
        val repository = CustomerRepository(dao)
        val factory = CustomerViewModelFactory(repository)
        customerViewModel = ViewModelProvider(this,factory).get(CustomerViewModel::class.java)
        binding.myViewModel = customerViewModel
        binding.lifecycleOwner = this
        displayCustomerList()
    }

    private fun displayCustomerList(){
     customerViewModel.customer.observe(this,Observer{
        Log.i("MyTag",it.toString())
     })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}