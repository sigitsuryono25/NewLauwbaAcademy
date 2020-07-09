package com.surelabs.request.newlauwbaacademy.ui.mycourses

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyCoursesViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is mycourses Fragment"
    }
    val text: LiveData<String> = _text
}