package com.tcs.dadjoke.ui.main.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tcs.dadjoke.data.model.Joke
import com.tcs.dadjoke.data.repository.JokeRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.observers.DisposableSingleObserver
import io.reactivex.rxjava3.schedulers.Schedulers

/**
 * Created by astirtrotter on 3/2/22
 */
class MainViewModel: ViewModel() {
    val liveData = MutableLiveData<ArrayList<Joke>>()
    private val jokes = arrayListOf<Joke>()
    private val compositeDisposable = CompositeDisposable()

    fun add() {
        compositeDisposable.add(JokeRepository.getJoke()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object: DisposableSingleObserver<Joke>() {
                override fun onSuccess(joke: Joke) {
                    jokes.add(joke)
                    liveData.postValue(jokes)
                }

                override fun onError(e: Throwable) {
                    e.printStackTrace()
                }
            })
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}