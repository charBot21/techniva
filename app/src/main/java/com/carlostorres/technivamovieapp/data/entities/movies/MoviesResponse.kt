package com.carlostorres.technivamovieapp.data.entities.movies

import com.google.gson.annotations.SerializedName

data class MoviesResponse(
    @SerializedName("dates") var dates: Dates? = Dates(),
    @SerializedName("page") var page: Int? = null,
    @SerializedName("results") var results: List<Results>,
    @SerializedName("total_pages") var totalPages: Int? = null,
    @SerializedName("total_results") var totalResults : Int? = null
)
