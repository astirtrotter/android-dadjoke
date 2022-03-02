package com.tcs.dadjoke.data.api

import com.tcs.dadjoke.data.model.Joke
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

/**
 * Created by astirtrotter on 3/2/22
 */
interface ApiService {

    companion object {
        const val BASE_URL = "https://icanhazdadjoke.com/"
    }

    @Headers("Accept: application/json")
    @GET("/")
    fun getJoke(): Single<Joke>
}