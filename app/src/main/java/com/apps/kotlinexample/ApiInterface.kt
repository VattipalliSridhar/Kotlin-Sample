package com.apps.kotlinexample

import com.apps.kotlinexample.model.LoginModel
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiInterface {

    @FormUrlEncoded
    @POST("login.php")
    fun getLogin(
        @Field("username") user: String,
        @Field("password") pass_code: String,
        @Field("accesskey") access_key: String
    ): Call<LoginModel>


}