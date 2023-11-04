package com.carlostorres.technivamovieapp.common.viewutils

import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment

fun Fragment.toast(message: Int) {
    Toast.makeText(requireContext(), getString(message), Toast.LENGTH_SHORT).show()
}

fun ProgressBar.show() {
    visibility = View.VISIBLE
}

fun ProgressBar.gone() {
    visibility = View.GONE
}