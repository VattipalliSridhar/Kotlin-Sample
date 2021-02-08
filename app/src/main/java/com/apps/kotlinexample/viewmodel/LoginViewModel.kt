package com.apps.kotlinexample.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.apps.kotlinexample.model.LoginModel
import com.apps.kotlinexample.repository.LoginRepository

class LoginViewModel : ViewModel() {

    var loginLiveData : MutableLiveData<LoginModel>? = null

    fun getLoginDetails():LiveData<LoginModel>?{

        return loginLiveData
    }

    fun getSetLogin(s: String, s1: String, s2: String) {
        loginLiveData = LoginRepository.getLoginApi("vmax14","Manager@321","123")
    }


}
