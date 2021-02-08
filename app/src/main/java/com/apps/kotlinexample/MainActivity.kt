package com.apps.kotlinexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.apps.kotlinexample.viewmodel.LoginViewModel

class MainActivity : AppCompatActivity(), RecyclerAdapter.OnItemClickListener {


    lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        //getting recyclerview from xml
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        //adding a layoutmanager
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        //crating an arraylist to store users using the data class user
        val users = ArrayList<User>()

        //adding some dummy data to the list
        users.add(User("Belal Khan", ""))
        users.add(User("Ramiz Khan", "Ranchi Jharkhand"))
        users.add(User("Faiz Khan", "Ranchi Jharkhand"))
        users.add(User("Yashar Khan", "Ranchi Jharkhand"))

        recyclerView.adapter = RecyclerAdapter(users,this)


        loginViewModel!!.getSetLogin("vmax14","Manager@321","123")
        loginViewModel!!.getLoginDetails()?.observe(this, Observer {
            if(it.status==200)
            {
               Log.e("msg","${it.message}")
            }
        })


    }

    override fun onItemClick(position: Int) {
        Toast.makeText(this, "Item $position clicked", Toast.LENGTH_SHORT).show()
    }
}