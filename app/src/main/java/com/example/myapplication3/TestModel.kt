package com.example.myapplication3

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TestModel: ViewModel() {
    val num = MutableLiveData<Int>()
    val text: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    init {
        num.value = 0
    }

    fun inCrease() {
        num.value = num.value?.plus(1)
    }
}