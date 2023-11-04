package com.carlostorres.technivamovieapp.ui.interfaces

interface MovieListener {
    fun onError()
    fun showProgressBar()
    fun hideProgressBar()
    fun itemClicked(idMovie: Int, position: Int )
}