package com.surelabs.request.newlauwbaacademy.ui.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.surelabs.request.newlauwbaacademy.model.coursesbykategori.ResponseCoursesByKategori
import com.surelabs.request.newlauwbaacademy.repo.Repository

class SearchViewModel : ViewModel() {

    val searchResult = MutableLiveData<ResponseCoursesByKategori>()
    val searchThrowable = MutableLiveData<Throwable>()
    private val repository = Repository()

    fun doSearch(keyword: String?) {
        repository.doSearch(keyword, {
            searchResult.value = it
        }, {
            searchThrowable.value = it
        })
    }
}