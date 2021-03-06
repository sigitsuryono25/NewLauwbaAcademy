package com.surelabs.request.newlauwbaacademy.network

import com.surelabs.request.newlauwbaacademy.model.coursesbykategori.ResponseCoursesByKategori
import com.surelabs.request.newlauwbaacademy.model.detailcourses.ResponseDetailCourses
import com.surelabs.request.newlauwbaacademy.model.kategori.ResponseKategori
import io.reactivex.Observable
import retrofit2.http.*

interface ApiService {

    @GET("getCategoryList")
    fun getCategoryList(): Observable<ResponseKategori>

    @GET("coursesByCategory/{kategori}")
    fun coursesByCategory(@Path("kategori") kategori: String?): Observable<ResponseCoursesByKategori>

    @GET("getDetailCourses/{idCourses}")
    fun getDetailCourses(@Path("idCourses") idCourses: String?): Observable<ResponseDetailCourses>

    @GET("doSearch")
    fun doSearch(@Query("q") search: String?): Observable<ResponseCoursesByKategori>

    @FormUrlEncoded
    @POST("getYourCourses")
    fun getYourCourses(@Field("email") email: String?): Observable<ResponseCoursesByKategori>
}
