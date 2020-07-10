@file:Suppress("DEPRECATION")

package com.surelabs.request.newlauwbaacademy.ui.mycourses

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import com.surelabs.request.newlauwbaacademy.R
import com.surelabs.request.newlauwbaacademy.adapter.AdapterCourses
import com.surelabs.request.newlauwbaacademy.adapter.AdapterKategori
import com.surelabs.request.newlauwbaacademy.coursebycategory.CoursesByCategoryActivity
import com.surelabs.request.newlauwbaacademy.detailcourses.DetailCoursesActivity
import com.surelabs.request.newlauwbaacademy.model.coursesbykategori.ResponseCoursesByKategori
import com.surelabs.request.newlauwbaacademy.model.kategori.ResponseKategori
import com.surelabs.request.newlauwbaacademy.ui.featured.FeaturedViewModel
import kotlinx.android.synthetic.main.fragment_mycourses.*

class MyCoursesFragment : Fragment() {

    private lateinit var featuredViewModel: FeaturedViewModel
    private lateinit var myCoursesViewModel: MyCoursesViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        featuredViewModel =
            ViewModelProviders.of(this).get(FeaturedViewModel::class.java)
        myCoursesViewModel = ViewModelProviders.of(this).get(MyCoursesViewModel::class.java)
        return inflater.inflate(R.layout.fragment_mycourses, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*Kategori List*/
        featuredViewModel.kategoriList()
        featuredViewModel.kategoriResponse.observe(viewLifecycleOwner, Observer {
            setToAdapter(it)
        })
        featuredViewModel.kategoriThrowable.observe(viewLifecycleOwner, Observer {
            setToError(it)
        })

        /*myCourses*/
        myCoursesViewModel.getYourCourses("sigitharsy25@gmail.com")
        myCoursesViewModel.myCoursesResponse.observe(viewLifecycleOwner, Observer {
            setToAdapterMyCourses(it)
        })
        myCoursesViewModel.myCoursesThrowable.observe(viewLifecycleOwner, Observer {
            setToError(it)
        })
    }

    private fun setToAdapterMyCourses(result: ResponseCoursesByKategori?) {
        val data = result?.courseData
        val adapter = AdapterCourses(data, {
            Intent(activity, DetailCoursesActivity::class.java).apply {
                putExtra("data", it)
                startActivity(this)
            }
        }, false)

        myCoursesRv.adapter = adapter
        myCoursesRv.itemAnimator = DefaultItemAnimator()
        adapter.notifyDataSetChanged()
    }

    private fun setToError(error: Throwable) {
        Log.e("Error: ", error.message.toString())
    }

    private fun setToAdapter(result: ResponseKategori?) {
        if (result?.code == 200) {
            empty.visibility = View.GONE
            val data = result.data
            val adapter = AdapterKategori(data) {
                Intent(activity, CoursesByCategoryActivity::class.java).apply {
                    putExtra("data", it?.namaSeo)
                    startActivity(this)
                }
            }

            kategoriRv.adapter = adapter
            kategoriRv.itemAnimator = DefaultItemAnimator()
            adapter.notifyDataSetChanged()
        } else {
            empty.visibility = View.VISIBLE
        }
    }
}