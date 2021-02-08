package com.apps.kotlinexample.repository

import androidx.lifecycle.MutableLiveData
import com.apps.kotlinexample.RetrofitClient
import com.apps.kotlinexample.model.LoginModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object LoginRepository {

    var getLoginData = MutableLiveData<LoginModel>()

    fun getLoginApi(username: String, passWord: String, accessKey: String): MutableLiveData<LoginModel>{

        val call = RetrofitClient.apiInterface.getLogin(username,passWord,accessKey)

        call.enqueue(object : Callback<LoginModel> {
            override fun onResponse(call: Call<LoginModel>, response: Response<LoginModel>) {
                if (response.isSuccessful)
                {
                    getLoginData.value=response.body()
                }else{
                    getLoginData.value=response.body()
                }
            }

            override fun onFailure(call: Call<LoginModel>, t: Throwable) {

            }

        })


        return getLoginData
    }
}