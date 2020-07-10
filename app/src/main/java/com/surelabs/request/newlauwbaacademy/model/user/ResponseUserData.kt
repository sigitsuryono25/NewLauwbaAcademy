package com.surelabs.request.newlauwbaacademy.model.user

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResponseUserData(

	@field:SerializedName("userdata")
	val userdata: List<UserdataItem?>? = null,

	@field:SerializedName("code")
	val code: Int? = null,

	@field:SerializedName("message")
	val message: String? = null
) : Parcelable

@Parcelize
data class UserdataItem(

	@field:SerializedName("telp")
	val telp: String? = null,

	@field:SerializedName("nama")
	val nama: String? = null,

	@field:SerializedName("terdaftar_pada")
	val terdaftarPada: String? = null,

	@field:SerializedName("email")
	val email: String? = null
) : Parcelable
