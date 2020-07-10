package com.surelabs.request.newlauwbaacademy.repo

import com.surelabs.request.newlauwbaacademy.model.coursesbykategori.ResponseCoursesByKategori
import com.surelabs.request.newlauwbaacademy.model.detailcourses.ResponseDetailCourses
import com.surelabs.request.newlauwbaacademy.model.kategori.ResponseKategori
import com.surelabs.request.newlauwbaacademy.network.NetworkModule
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class Repository {
    private val api = NetworkModule.getService()
    private val disposable = CompositeDisposable()

    fun getDetailCourses(
        idCourses: String?,
        response: (ResponseDetailCourses) -> Unit,
        throwable: (Throwable) -> Unit
    ) {
        disposable.add(
            api.getDetailCourses(idCourses)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    response(it)
                }, {
                    throwable(it)
                })
        )
    }

    fun getCategoryList(
        response: (ResponseKategori) -> Unit,
        throwable: (Throwable) -> Unit
    ) {
        disposable.add(
            api.getCategoryList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    response(it)
                }, {
                    throwable(it)
                })
        )
    }

    fun coursesByCategory(
        kategori: String?, response: (ResponseCoursesByKategori) -> Unit,
        throwable: (Throwable) -> Unit
    ) {
        disposable.add(
            api.coursesByCategory(kategori)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    response(it)
                }, {
                    throwable(it)
                })
        )
    }

    fun doSearch(
        search: String?, response: (ResponseCoursesByKategori) -> Unit,
        throwable: (Throwable) -> Unit
    ) {
        disposable.add(
            api.doSearch(search)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    response(it)
                }, {
                    throwable(it)
                })
        )
    }

    fun getYourCourses(
        email: String?, response: (ResponseCoursesByKategori) -> Unit,
        throwable: (Throwable) -> Unit
    ) {
        disposable.add(
            api.getYourCourses(email)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    response(it)
                }, {
                    throwable(it)
                })
        )
    }
}