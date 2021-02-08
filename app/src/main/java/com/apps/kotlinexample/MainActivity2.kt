package com.apps.kotlinexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders

class MainActivity2 : AppCompatActivity() {
    var loginViewClass: LoginViewClass? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        loginViewClass = ViewModelProviders.of(this).get(LoginViewClass::class.java)
        loginViewClass!!.getData("sh", "bv")
    }
}