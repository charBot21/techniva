package com.carlostorres.technivamovieapp.data.network

import android.os.Environment
import com.carlostorres.technivamovieapp.common.constants.ApiConstants
import com.carlostorres.technivamovieapp.data.entities.details.DetailsResponse
import com.carlostorres.technivamovieapp.data.entities.movies.MoviesResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieService {

    @Headers("Authorization: Bearer ${ApiConstants.API_TOKEN}")
    @GET(ApiConstants.MOVIE_LIST)
    suspend fun getMovies(
        @Query("api_key") apiKey: String,
        @Query("page") page: String
    ): Response<MoviesResponse>


    @Headers("Authorization: Bearer ${ApiConstants.API_TOKEN}")
    @GET("{idMovie}?language=es-MX")
    suspend fun getMovieDetail(
        @Path("idMovie") idMovie: String,
        @Query("api_key") apiKey: String
    ): Response<DetailsResponse>
}