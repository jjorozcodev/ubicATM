package com.soyjj.ubicatm.ApiData

import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit

class ApiService {
    companion object{
        private val URL = "https://my-json-server.typicode.com/soy-jj/api-fake/"
        fun instance(): IApi {
            val retrofit = Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create<IApi>(IApi::class.java)
        }
    }
}