package com.carlostorres.technivamovieapp.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.carlostorres.technivamovieapp.R
import com.carlostorres.technivamovieapp.common.constants.ApiConstants
import com.carlostorres.technivamovieapp.data.entities.movies.Results
import com.carlostorres.technivamovieapp.ui.interfaces.MovieListener

class MovieAdapter(
    var movieList: List<Results>,
    private var clickItem: MovieListener
): RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MovieViewHolder(inflater.inflate(R.layout.item_movie, parent, false))
    }

    override fun onBindViewHolder(holder: MovieAdapter.MovieViewHolder, position: Int) {
        holder.initialize(movieList[position], clickItem)
    }

    override fun getItemCount() = movieList.size

    class MovieViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private var tvTitle: TextView = view.findViewById(R.id.movieTitle)
        private var tvDate: TextView = view.findViewById(R.id.movieDate)
        private var imagePoster: ImageView = view.findViewById(R.id.moviePoster)

        fun initialize(items: Results, action: MovieListener ) {
            tvTitle.text = items.originalTitle
            tvDate.text = items.releaseDate
            Glide.with(imagePoster.context)
                .load("${ApiConstants.URL_IMAGE}${items.posterPath}")
                .into(imagePoster)

            itemView.setOnClickListener {
                action.itemClicked(items.id!!, adapterPosition)
            }
        }
    }
}