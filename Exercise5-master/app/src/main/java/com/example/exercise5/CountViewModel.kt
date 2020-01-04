package com.example.exercise5

import android.util.Log
import androidx.lifecycle.ViewModel

class CountViewModel : ViewModel() {
    var countLike: Int = 0
    var countDislike: Int = 0

    fun setLike(set : Int)
    {
       countLike = set
    }

   fun setDislike(set : Int)
    {
        countDislike = set
    }

    fun like(plus : Int)
    {
        countLike = countLike + plus
    }

    fun dislike(plus : Int)
    {
        countDislike = countDislike + plus
    }

    fun returnLike() : Int
    {
        return countLike
    }

    fun returnDislike() : Int
    {
        return countDislike
    }

    init {
        Log.i("GameViewModel", "GameViewModel created!")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("GameViewModel", "GameViewModel destroyed!")
    }
}