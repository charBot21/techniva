package com.carlostorres.technivamovieapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.carlostorres.technivamovieapp.common.constants.ApiConstants
import com.carlostorres.technivamovieapp.common.constants.emptyString
import com.carlostorres.technivamovieapp.data.entities.movies.Results
import com.carlostorres.technivamovieapp.data.network.MovieClient
import com.carlostorres.technivamovieapp.ui.interfaces.MovieListener
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.Locale

class HomeViewModel: ViewModel() {

    var moviesListener: MovieListener ?= null
    val title = MutableLiveData(emptyString())
    private var _page = 1
    private var _list: MutableList<Results> = mutableListOf()
    private var _isAvailableRefresh: MutableLiveData<Boolean> = MutableLiveData()
    private var _listLiveData: MutableLiveData<MutableList<Results>> = MutableLiveData()

    init {
        _isAvailableRefresh.value = true
    }

    fun getAvailableRefreshObserver(): MutableLiveData<Boolean> {
        return _isAvailableRefresh
    }

    fun getListObserver(): MutableLiveData<MutableList<Results>> {
        return _listLiveData
    }

    fun onGetMovies() {
        if ( title.value.isNullOrEmpty() || _list.isNullOrEmpty() ) {
            moviesListener?.showProgressBar()
            viewModelScope.launch(Dispatchers.IO) {
                val response = MovieClient.movieService.getMovies(ApiConstants.API_KEY, _page.toString())
                withContext(Dispatchers.Main) {
                    if ( response.isSuccessful ) {
                        response.body()?.results!!.forEach {
                            _list.add(it)
                        }
                        _isAvailableRefresh.postValue(false)
                        _listLiveData.postValue(_list)
                    } else {
                        _isAvailableRefresh.postValue(true)
                        moviesListener?.onError()
                    }
                    moviesListener?.hideProgressBar()
                }
            }
        }

    }

    fun updateMovieList() {
        _page++
        onGetMovies()
    }

    fun onSearchMovie() {
        val listTmp = mutableListOf<Results>()
        if ( title.value.isNullOrEmpty() ) {
            _page = 1
            _listLiveData.postValue(_list)
        } else {
            _list.forEach {
                if ( it.originalTitle!!.lowercase().startsWith(title.value!!.lowercase(Locale.ROOT)) ) {
                    listTmp.add(it)
                }
            }
            _listLiveData.postValue(listTmp)
        }

    }

}