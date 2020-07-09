package com.surelabs.request.newlauwbaacademy.model.coursesbykategori

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResponseCoursesByKategori(

	@field:SerializedName("code")
	val code: Int? = null,

	@field:SerializedName("course_data")
	val courseData: List<CourseDataItem?>? = null,

	@field:SerializedName("message")
	val message: String? = null
) : Parcelable

@Parcelize
data class CourseDataItem(

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("id_kategori")
	val idKategori: String? = null,

	@field:SerializedName("id_course")
	val idCourse: String? = null,

	@field:SerializedName("harga_coret")
	val hargaCoret: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("yang_dipelajari")
	val yangDipelajari: String? = null,

	@field:SerializedName("harga_normal")
	val hargaNormal: String? = null,

	@field:SerializedName("video_preview")
	val videoPreview: String? = null,

	@field:SerializedName("nama_course")
	val namaCourse: String? = null,

	@field:SerializedName("course_cover")
	val courseCover: String? = null,

	@field:SerializedName("trainer")
	val trainer: String? = null,

	@field:SerializedName("video_preview_file")
	val videoPreviewFile: String? = null,

	@field:SerializedName("course_cover_file")
	val courseCoverFile: String? = null,

	@field:SerializedName("id_kelas")
	val idKelas: String? = null,

	@field:SerializedName("deskripsi")
	val deskripsi: String? = null,


	@field:SerializedName("nama")
	val nama: String? = null,

	@field:SerializedName("slug_title")
	val slugTitle: String? = null
) : Parcelable
