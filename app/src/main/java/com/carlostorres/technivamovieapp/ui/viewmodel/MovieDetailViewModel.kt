package com.carlostorres.technivamovieapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.carlostorres.technivamovieapp.common.constants.ApiConstants
import com.carlostorres.technivamovieapp.data.entities.details.DetailsResponse
import com.carlostorres.technivamovieapp.data.network.MovieClient
import com.carlostorres.technivamovieapp.ui.interfaces.MovieDetailListener
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieDetailViewModel: ViewModel() {

    var movieDetailListener: MovieDetailListener ?= null
    var movieList: MutableLiveData<DetailsResponse?> = MutableLiveData()
    private var isAvailableRefresh: MutableLiveData<Boolean> = MutableLiveData()

    init {
        isAvailableRefresh.value = true
    }

    fun getAvailableRefreshObserver(): MutableLiveData<Boolean> {
        return isAvailableRefresh
    }

    fun onGetDetail(idMovie: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = MovieClient.movieService.getMovieDetail(idMovie, ApiConstants.API_KEY)
            withContext(Dispatchers.Main) {
                if ( response.isSuccessful ) {
                    movieList.postValue(response.body()!!)
                    isAvailableRefresh.value = false
                } else {
                    movieList.postValue(null)
                    isAvailableRefresh.value = true
                    movieDetailListener?.onError()
                }
            }
        }
    }

}