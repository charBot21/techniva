package com.carlostorres.technivamovieapp.common.viewutils

import android.widget.ImageView
import androidx.core.widget.addTextChangedListener
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.carlostorres.technivamovieapp.common.constants.ApiConstants
import com.google.android.material.textfield.TextInputEditText

@BindingAdapter("setImage")
fun ImageView.setImage(imagePath: String?) {

    val path = if ( ApiConstants.URL_IMAGE+imagePath != "" || ApiConstants.URL_IMAGE+imagePath != null ) ApiConstants.URL_IMAGE+imagePath else ""

    imagePath?.let {
        Glide.with(context)
            .load(path)
            .into(this)
    }
}


@BindingAdapter("onTextChanged")
fun TextInputEditText.onTextChanged(onTextChanged: OnTextChange) {
    addTextChangedListener {
        onTextChanged.onChangedText()
    }
}

interface OnTextChange {
    fun onChangedText()
}