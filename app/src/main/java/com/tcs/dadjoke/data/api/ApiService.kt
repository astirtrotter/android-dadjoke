package com.tcs.dadjoke.data.api

import com.tcs.dadjoke.data.model.Joke
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

/**
 * Created by astirtrotter on 3/2/22
 */
interface ApiService {

    companion object {
        const val BASE_URL = "https://icanhazdadjoke.com/api/"
    }

    @GET("users")
    fun getJoke(): Single<Joke>
}