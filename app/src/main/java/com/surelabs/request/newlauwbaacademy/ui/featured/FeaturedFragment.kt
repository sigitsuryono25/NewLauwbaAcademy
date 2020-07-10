@file:Suppress("DEPRECATION")

package com.surelabs.request.newlauwbaacademy.ui.featured

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import com.surelabs.request.newlauwbaacademy.R
import com.surelabs.request.newlauwbaacademy.adapter.AdapterCourses
import com.surelabs.request.newlauwbaacademy.coursebycategory.CoursesByCategoryActivity
import com.surelabs.request.newlauwbaacademy.detailcourses.DetailCoursesActivity
import com.surelabs.request.newlauwbaacademy.model.coursesbykategori.ResponseCoursesByKategori
import com.surelabs.request.newlauwbaacademy.model.kategori.ResponseKategori
import kotlinx.android.synthetic.main.fragment_featured.*

class FeaturedFragment : Fragment() {

    private lateinit var featuredViewModel: FeaturedViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        featuredViewModel =
            ViewModelProviders.of(this).get(FeaturedViewModel::class.java)
        return inflater.inflate(R.layout.fragment_featured, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*
        * android
        * */
        featuredViewModel.androidCourses()
        featuredViewModel.androidResponseCoursesByKategori.observe(viewLifecycleOwner, Observer {
            setToAdapter("android", it)
        })
        featuredViewModel.androidThrowable.observe(viewLifecycleOwner, Observer {
            setToError("android", it)
        })

        /*Flutter*/
        featuredViewModel.flutterCourses()
        featuredViewModel.flutterResponseCoursesByKategori.observe(viewLifecycleOwner, Observer {
            setToAdapter("flutter", it)
        })
        featuredViewModel.flutterThrowable.observe(viewLifecycleOwner, Observer {
            setToError("flutter", it)
        })

        /*Flutter*/
        featuredViewModel.digitalMarketingCourses()
        featuredViewModel.digitalMarketingResponseCoursesByKategori.observe(
            viewLifecycleOwner,
            Observer {
                setToAdapter("digital-marketing", it)
            })
        featuredViewModel.digitalMarketingThrowable.observe(viewLifecycleOwner, Observer {
            setToError("digital-marketing", it)
        })

        /*ios*/
        featuredViewModel.iOSCourses()
        featuredViewModel.iOSResponseCoursesByKategori.observe(viewLifecycleOwner, Observer {
            setToAdapter("ios", it)
        })
        featuredViewModel.iOSThrowable.observe(viewLifecycleOwner, Observer {
            setToError("ios", it)
        })

        /*seo*/
        featuredViewModel.seoCourses()
        featuredViewModel.seoResponseCoursesByKategori.observe(viewLifecycleOwner, Observer {
            setToAdapter("seo", it)
        })
        featuredViewModel.seoThrowable.observe(viewLifecycleOwner, Observer {
            setToError("seo", it)
        })

        /*web*/
        featuredViewModel.webCourses()
        featuredViewModel.webResponseCoursesByKategori.observe(viewLifecycleOwner, Observer {
            setToAdapter("web", it)
        })
        featuredViewModel.webThrowable.observe(viewLifecycleOwner, Observer {
            setToError("web", it)
        })

        //kategori list*/
        featuredViewModel.kategoriList()
        featuredViewModel.kategoriResponse.observe(viewLifecycleOwner, Observer {
            setToKategoriBox(it)
        })
        featuredViewModel.kategoriThrowable.observe(viewLifecycleOwner, Observer {
            setToError("kategori", it)
        })
    }

    private fun setToKategoriBox(kategoriResponse: ResponseKategori?) {
        val kategoriData = kategoriResponse?.data
        kategoriData?.forEachIndexed { index, s ->
            val kategoriItem = TextView(activity)
            kategoriItem.text = s?.namaKategori
            kategoriItem.setTextColor(Color.BLACK)
            kategoriItem.background = resources.getDrawable(R.drawable.bg_kategori)
            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            params.setMargins(8, 8, 8, 8)
            kategoriItem.layoutParams = params
            kategoriItem.setOnClickListener {
                Intent(activity, CoursesByCategoryActivity::class.java).apply {
                    putExtra("data", s?.namaSeo)
                    startActivity(this)
                }
            }

            kategoriList.addView(kategoriItem, index)
        }
    }

    private fun setToError(kategori: String?, throwable: Throwable) {
        Log.e("Error: $kategori-->", throwable.message.toString())
    }

    private fun setToAdapter(
        kategori: String,
        responseCoursesByKategori: ResponseCoursesByKategori
    ) {
        when (kategori) {
            "android" -> {
                val data = responseCoursesByKategori.courseData
                val adapter = AdapterCourses(data, {
                    Intent(activity, DetailCoursesActivity::class.java).apply {
                        putExtra("data", it)
                        startActivity(this)
                    }
                })
                androidRv.itemAnimator = DefaultItemAnimator()
                androidRv.adapter = adapter
            }
            "flutter" -> {
                val data = responseCoursesByKategori.courseData
                val adapter = AdapterCourses(data, {
                    Intent(activity, DetailCoursesActivity::class.java).apply {
                        putExtra("data", it)
                        startActivity(this)
                    }
                })
                flutterRv.itemAnimator = DefaultItemAnimator()
                flutterRv.adapter = adapter
            }

            "seo" -> {
                val data = responseCoursesByKategori.courseData
                val adapter = AdapterCourses(data, {
                    Intent(activity, DetailCoursesActivity::class.java).apply {
                        putExtra("data", it)
                        startActivity(this)
                    }
                })
                seoRv.itemAnimator = DefaultItemAnimator()
                seoRv.adapter = adapter
            }

            "digital-marketing" -> {
                val data = responseCoursesByKategori.courseData
                val adapter = AdapterCourses(data, {
                    Intent(activity, DetailCoursesActivity::class.java).apply {
                        putExtra("data", it)
                        startActivity(this)
                    }
                })
                digitalMarketingRv.itemAnimator = DefaultItemAnimator()
                digitalMarketingRv.adapter = adapter
            }

            "ios" -> {
                val data = responseCoursesByKategori.courseData
                val adapter = AdapterCourses(data, {
                    Intent(activity, DetailCoursesActivity::class.java).apply {
                        putExtra("data", it)
                        startActivity(this)
                    }
                })
                iOSRv.itemAnimator = DefaultItemAnimator()
                iOSRv.adapter = adapter
            }

            "web" -> {
                val data = responseCoursesByKategori.courseData
                val adapter = AdapterCourses(data, {
                    Intent(activity, DetailCoursesActivity::class.java).apply {
                        putExtra("data", it)
                        startActivity(this)
                    }
                })
                webRv.itemAnimator = DefaultItemAnimator()
                webRv.adapter = adapter
            }
        }
    }
}