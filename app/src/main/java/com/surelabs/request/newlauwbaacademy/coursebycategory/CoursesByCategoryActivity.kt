package com.surelabs.request.newlauwbaacademy.coursebycategory

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DefaultItemAnimator
import com.surelabs.request.newlauwbaacademy.R
import com.surelabs.request.newlauwbaacademy.adapter.AdapterCourses
import com.surelabs.request.newlauwbaacademy.model.coursesbykategori.ResponseCoursesByKategori
import kotlinx.android.synthetic.main.activity_courses_by_category.*

class CoursesByCategoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courses_by_category)

        val kategori = intent.getStringExtra("data")

        supportActionBar?.title = "Kategori: $kategori"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        val coursesByCategoryViewModel: CoursesByCategoryViewModel by viewModels()
        coursesByCategoryViewModel.coursesByCategory(kategori)
        coursesByCategoryViewModel.coursesResult.observe(this, Observer {
            setToAdapter(it)
        })

        coursesByCategoryViewModel.coursesThrowable.observe(this, Observer {
            setError(it)
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setError(error: Throwable?) {
        Log.e("error", error?.message.toString())
    }

    private fun setToAdapter(result: ResponseCoursesByKategori?) {
        if (result?.code == 200) {
            val data = result.courseData
            val adapter = AdapterCourses(data, {

            }, true)
            coursesRv.itemAnimator = DefaultItemAnimator()
            coursesRv.adapter = adapter
        } else {
            Toast.makeText(this@CoursesByCategoryActivity, result?.message, Toast.LENGTH_SHORT)
                .show()
        }
    }
}