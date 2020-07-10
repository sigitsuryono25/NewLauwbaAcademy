@file:Suppress("DEPRECATION")

package com.surelabs.request.newlauwbaacademy.ui.login

import android.app.Dialog
import android.app.ProgressDialog
import android.content.res.Resources
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import android.widget.RelativeLayout
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.surelabs.request.newlauwbaacademy.R

class LoginBottomSheets : BottomSheetDialogFragment() {
    private var behavior: BottomSheetBehavior<View>? = null
    private var login: MaterialButton? = null
    private var progressDialog: ProgressDialog? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val bottomSheets = super.onCreateDialog(savedInstanceState) as BottomSheetDialog
        val view = View.inflate(context, R.layout.fragment_login_bottom_sheets, null)
        val root = view.findViewById<RelativeLayout>(R.id.root)
        val params = RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.MATCH_PARENT,
            RelativeLayout.LayoutParams.MATCH_PARENT
        )
        params.height = getScreenHeight()
        root.layoutParams = params

        bottomSheets.setContentView(view)
        behavior = BottomSheetBehavior.from(view.parent as View)

        // prevent from dragging
        bottomSheets.setOnShowListener {
            val bottomSheet =
                (it as BottomSheetDialog).findViewById<View>(com.google.android.material.R.id.design_bottom_sheet) as FrameLayout?
            val behavior = BottomSheetBehavior.from(bottomSheet!!)
            behavior.state = BottomSheetBehavior.STATE_EXPANDED

            behavior.setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
                override fun onStateChanged(bottomSheet: View, newState: Int) {
                    if (newState == BottomSheetBehavior.STATE_DRAGGING) {
                        behavior.state = BottomSheetBehavior.STATE_EXPANDED
                    }
                }

                override fun onSlide(bottomSheet: View, slideOffset: Float) {}
            })
        }

        //login proses
        login = view.findViewById(R.id.btnLogin)
        val username = view.findViewById<TextInputEditText>(R.id.username)
        val password = view.findViewById<TextInputEditText>(R.id.password)

        login?.setOnClickListener {
            if (username.text?.isEmpty() == true || password.text?.isEmpty() == true) {
                Toast.makeText(
                    activity,
                    "Silahkan isi semua kolom terlebih dahulu",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                progressDialog = ProgressDialog.show(activity, "", "Silahkan tunggu", true, false)
                login?.isEnabled = false
            }
        }

        return bottomSheets
    }


    private fun getScreenHeight(): Int {
        return Resources.getSystem().displayMetrics.heightPixels
    }
}