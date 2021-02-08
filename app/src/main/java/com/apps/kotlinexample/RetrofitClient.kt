package com.apps.kotlinexample

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {


    private val retrofitClint: Retrofit.Builder by lazy {

        val levelType: HttpLoggingInterceptor.Level
        if (BuildConfig.BUILD_TYPE.contentEquals("debug"))
            levelType = HttpLoggingInterceptor.Level.BODY else levelType =
            HttpLoggingInterceptor.Level.NONE

        val logging = HttpLoggingInterceptor()
        logging.setLevel(levelType)

        val okHttpClient = OkHttpClient.Builder()
        okHttpClient.addInterceptor(logging)

        Retrofit.Builder()
            .baseUrl(Constants.Base_Url)
            .client(okHttpClient.build())
            .addConverterFactory(GsonConverterFactory.create())

    }

    val apiInterface: ApiInterface by lazy {
        retrofitClint
            .build()
            .create(ApiInterface::class.java)
    }
}


