package com.soyjj.ubicatm.ApiData

import com.soyjj.ubicatm.Models.ATM
import io.reactivex.Observable
import retrofit2.http.GET

interface IApi {
    @GET("atms")
    fun getATMs() : Observable<List<ATM>>
}