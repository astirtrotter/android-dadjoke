package com.tcs.dadjoke.ui.main.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tcs.dadjoke.data.model.Joke

/**
 * Created by astirtrotter on 3/2/22
 */
class MainViewModel: ViewModel() {
    val liveData = MutableLiveData<ArrayList<Joke>>()
    private val jokes = arrayListOf<Joke>()

    fun add(joke: Joke) {
        jokes.add(joke)
        liveData.value = jokes
    }

    fun remove(joke: Joke) {
        jokes.remove(joke)
        liveData.value = jokes
    }

    fun size() = jokes.size
}