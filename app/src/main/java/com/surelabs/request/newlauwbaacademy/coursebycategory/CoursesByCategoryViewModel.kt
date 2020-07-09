package com.surelabs.request.newlauwbaacademy.coursebycategory

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.surelabs.request.newlauwbaacademy.model.coursesbykategori.ResponseCoursesByKategori
import com.surelabs.request.newlauwbaacademy.repo.Repository

class CoursesByCategoryViewModel: ViewModel() {
    val coursesResult = MutableLiveData<ResponseCoursesByKategori>()
    val coursesThrowable = MutableLiveData<Throwable>()
    private val repository = Repository()

    fun coursesByCategory(keyword: String?) {
        repository.coursesByCategory(keyword, {
            coursesResult.value = it
        }, {
            coursesThrowable.value = it
        })
    }
}