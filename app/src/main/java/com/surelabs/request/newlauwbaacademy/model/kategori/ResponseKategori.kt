package com.surelabs.request.newlauwbaacademy.model.kategori

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResponseKategori(

    @field:SerializedName("code")
    val code: Int? = null,

    @field:SerializedName("data")
    val data: List<DataItemKategori?>? = null,

    @field:SerializedName("message")
    val message: String? = null
) : Parcelable

@Parcelize
data class DataItemKategori(

    @field:SerializedName("nama_seo")
    val namaSeo: String? = null,

    @field:SerializedName("kategori_seo")
    val kategoriSeo: String? = null,

    @field:SerializedName("nama_kategori")
    val namaKategori: String? = null,

    @field:SerializedName("mobile_icon")
    val mobileIcon: String? = null
) : Parcelable
