package com.carlostorres.technivamovieapp.data.entities.movies

import com.google.gson.annotations.SerializedName

data class Dates(
    @SerializedName("maximum" ) var maximum : String? = null,
    @SerializedName("minimum" ) var minimum : String? = null
)
