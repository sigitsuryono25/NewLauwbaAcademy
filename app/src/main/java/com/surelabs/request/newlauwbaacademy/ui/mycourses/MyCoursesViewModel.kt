package com.surelabs.request.newlauwbaacademy.ui.mycourses

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.surelabs.request.newlauwbaacademy.model.coursesbykategori.ResponseCoursesByKategori
import com.surelabs.request.newlauwbaacademy.repo.Repository

class MyCoursesViewModel : ViewModel() {


    val myCoursesResponse = MutableLiveData<ResponseCoursesByKategori>()
    val myCoursesThrowable = MutableLiveData<Throwable>()

    private var repository: Repository = Repository()

    fun getYourCourses(email: String?) {
        repository.getYourCourses(email, {
            myCoursesResponse.value = it
        }, {
            myCoursesThrowable.value = it
        })
    }
}