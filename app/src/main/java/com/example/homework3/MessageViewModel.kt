package com.example.homework3

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MessageViewModel : ViewModel() {
    private val _message: MutableLiveData<String> = MutableLiveData()

    var message: LiveData<String> = _message

    fun setMessage(newMessage: String) {
        _message.value = newMessage
    }
}