package com.surelabs.request.newlauwbaacademy.adapter

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.surelabs.request.newlauwbaacademy.R
import com.surelabs.request.newlauwbaacademy.model.coursesbykategori.CourseDataItem
import kotlinx.android.synthetic.main.item_adapter_courses.view.*
import kotlin.random.Random


class AdapterCourses(
    private val coursesList: List<CourseDataItem?>?,
    private val click: (CourseDataItem?) -> Unit,
    private val isSearch: Boolean = false
) : RecyclerView.Adapter<AdapterCourses.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val coverCourses = itemView.coverCourses
        private val coursesName = itemView.coursesName
        private val createdBy = itemView.createdBy
        private val rating = itemView.rate
        private val harga = itemView.harga
        private val hargaCoret = itemView.hargaCoret

        fun onBindItem(itemList: CourseDataItem?) {
            val random = Random.nextFloat()
            Glide.with(itemView.context).load(itemList?.courseCover).into(coverCourses)
            coursesName.text = itemList?.namaCourse
            createdBy.text = itemList?.nama
            rating.rating = random
            harga.text = itemList?.hargaNormal
            hargaCoret.text = itemList?.hargaCoret
            hargaCoret.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG

            //give click to itemView
            itemView.setOnClickListener {
                click(itemList)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return if (isSearch) {
            ViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_adapter_courses_search, parent, false)
            )
        } else {
            ViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_adapter_courses, parent, false)
            )
        }
    }

    override fun getItemCount(): Int = coursesList?.size ?: 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBindItem(coursesList?.get(position))
    }

}