package com.example.vmandldcodepalace

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class IncrementViewModel : ViewModel(){
    var number = 0

    val currentNumber: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    val currentBoolean: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
}