package com.example.androidcodingchallenge.service

import com.example.androidcodingchallenge.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Akash Kumar on 25/02/23.
 * https://github.com/eduxcellence
 * akkr2017@gmail.com
 */
/* It's a singleton class that creates an instance of the Retrofit object and returns it */
class ApiManager {


    companion object {
        var apiService: ApiService? = null
        fun getInstance(): ApiService {
            if (apiService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl(BuildConfig.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                apiService = retrofit.create(ApiService::class.java)
            }
            return apiService!!
        }

    }
}