package com.surelabs.request.newlauwbaacademy.ui.mycourses

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.surelabs.request.newlauwbaacademy.R

class MyCoursesFragment : Fragment() {

    private lateinit var myCoursesViewModel: MyCoursesViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        myCoursesViewModel =
                ViewModelProviders.of(this).get(MyCoursesViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_mycourses, container, false)
        val textView: TextView = root.findViewById(R.id.text_notifications)
        myCoursesViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}