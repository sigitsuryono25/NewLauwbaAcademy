@file:Suppress("DEPRECATION")

package com.surelabs.request.newlauwbaacademy.ui.search

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import com.surelabs.request.newlauwbaacademy.R
import com.surelabs.request.newlauwbaacademy.adapter.AdapterCourses
import com.surelabs.request.newlauwbaacademy.model.coursesbykategori.ResponseCoursesByKategori
import kotlinx.android.synthetic.main.fragment_search.*

class SearchFragment : Fragment() {

    private lateinit var searchViewModel: SearchViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        searchViewModel =
            ViewModelProviders.of(this).get(SearchViewModel::class.java)
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                searchViewModel.doSearch(p0)
                searchViewModel.searchResult.observe(viewLifecycleOwner, Observer {
                    setToAdapter(it)
                })
                searchViewModel.searchThrowable.observe(viewLifecycleOwner, Observer {
                    setToError(it)
                })
                return true
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                return false
            }

        })
    }

    private fun setToError(error: Throwable?) {
        Log.e("error", error?.message.toString())
    }

    private fun setToAdapter(result: ResponseCoursesByKategori?) {
        if (result?.code == 200) {
            val data = result.courseData
            val adapter = AdapterCourses(data, {

            }, true)
            searchResultRv.itemAnimator = DefaultItemAnimator()
            searchResultRv.adapter = adapter
        } else {
            Toast.makeText(context, result?.message, Toast.LENGTH_SHORT).show()
        }
    }
}