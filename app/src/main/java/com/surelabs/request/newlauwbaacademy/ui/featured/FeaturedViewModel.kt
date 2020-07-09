package com.surelabs.request.newlauwbaacademy.ui.featured

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.surelabs.request.newlauwbaacademy.model.coursesbykategori.ResponseCoursesByKategori
import com.surelabs.request.newlauwbaacademy.model.kategori.ResponseKategori
import com.surelabs.request.newlauwbaacademy.repo.Repository

class FeaturedViewModel : ViewModel() {

    val androidResponseCoursesByKategori = MutableLiveData<ResponseCoursesByKategori>()
    val androidThrowable = MutableLiveData<Throwable>()
    val flutterResponseCoursesByKategori = MutableLiveData<ResponseCoursesByKategori>()
    val flutterThrowable = MutableLiveData<Throwable>()
    val digitalMarketingResponseCoursesByKategori = MutableLiveData<ResponseCoursesByKategori>()
    val digitalMarketingThrowable = MutableLiveData<Throwable>()
    val iOSResponseCoursesByKategori = MutableLiveData<ResponseCoursesByKategori>()
    val iOSThrowable = MutableLiveData<Throwable>()
    val seoResponseCoursesByKategori = MutableLiveData<ResponseCoursesByKategori>()
    val seoThrowable = MutableLiveData<Throwable>()
    val webResponseCoursesByKategori = MutableLiveData<ResponseCoursesByKategori>()
    val webThrowable = MutableLiveData<Throwable>()
    val kategoriResponse = MutableLiveData<ResponseKategori>()
    val kategoriThrowable = MutableLiveData<Throwable>()

    private var repository: Repository = Repository()


    fun androidCourses() {
        repository.coursesByCategory("android", { response ->
            androidResponseCoursesByKategori.value = response
        }, { t ->
            androidThrowable.value = t
        })
    }

    fun flutterCourses() {
        repository.coursesByCategory("flutter", { response ->
            flutterResponseCoursesByKategori.value = response
        }, { t ->
            flutterThrowable.value = t
        })
    }

    fun digitalMarketingCourses() {
        repository.coursesByCategory("digital-marketing", { response ->
            digitalMarketingResponseCoursesByKategori.value = response
        }, { t ->
            digitalMarketingThrowable.value = t
        })
    }

    fun iOSCourses() {
        repository.coursesByCategory("ios", { response ->
            iOSResponseCoursesByKategori.value = response
        }, { t ->
            iOSThrowable.value = t
        })
    }

    fun seoCourses() {
        repository.coursesByCategory("seo", { response ->
            seoResponseCoursesByKategori.value = response
        }, { t ->
            seoThrowable.value = t
        })
    }

    fun webCourses() {
        repository.coursesByCategory("website", { response ->
            webResponseCoursesByKategori.value = response
        }, { t ->
            webThrowable.value = t
        })
    }

    fun kategoriList(){
        repository.getCategoryList({
            kategoriResponse.value = it
        },{
            kategoriThrowable.value = it
        })
    }

}