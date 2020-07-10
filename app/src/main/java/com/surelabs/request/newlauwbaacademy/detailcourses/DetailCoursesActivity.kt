@file:Suppress("DEPRECATION")

package com.surelabs.request.newlauwbaacademy.detailcourses

import android.graphics.Paint
import android.os.Bundle
import android.text.Html
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.surelabs.request.newlauwbaacademy.R
import com.surelabs.request.newlauwbaacademy.model.coursesbykategori.CourseDataItem
import kotlinx.android.synthetic.main.activity_detail_courses.*
import kotlinx.android.synthetic.main.layout_courses_created_by.*
import kotlinx.android.synthetic.main.layout_courses_descriptions.*
import kotlinx.android.synthetic.main.layout_courses_info_header.*
import kotlinx.android.synthetic.main.layout_courses_what_will_learn.*

class DetailCoursesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_courses)

        val coursesData = intent.getParcelableExtra<CourseDataItem>("data")

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = null

        coursesName.text = coursesData?.namaCourse
        harga.text = coursesData?.hargaNormal
        hargaCoret.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
        hargaCoret.text = coursesData?.hargaCoret
        Glide.with(this).load(coursesData?.courseCover).into(coursesCover)
        whatWillLearn.text = Html.fromHtml(coursesData?.yangDipelajari)
        description.text = Html.fromHtml(coursesData?.description)
        namaTrainer.text = coursesData?.nama
        Glide.with(this).load(coursesData?.image).apply(RequestOptions().circleCrop())
            .into(imageTrainer)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menu?.add(0, 0, 0, "Share")?.setIcon(R.drawable.ic_share)
            ?.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            0 -> {
                Toast.makeText(this, "Shared Clicked", Toast.LENGTH_SHORT).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}