package com.carlostorres.technivamovieapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.carlostorres.technivamovieapp.R
import com.carlostorres.technivamovieapp.common.viewutils.toast
import com.carlostorres.technivamovieapp.databinding.FragmentMovieDetailBinding
import com.carlostorres.technivamovieapp.ui.interfaces.MovieDetailListener
import com.carlostorres.technivamovieapp.ui.viewmodel.MovieDetailViewModel

class MovieDetailFragment : Fragment(), MovieDetailListener {

    private val viewModel: MovieDetailViewModel by viewModels()
    private val args: MovieDetailFragmentArgs by navArgs()

    private lateinit var binding: FragmentMovieDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMovieDetailBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel
        viewModel.movieDetailListener = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getAvailableRefreshObserver().observe(viewLifecycleOwner, Observer {
            if ( it ) {
                viewModel.onGetDetail(args.idMovie)
            }
        })
    }

    override fun onError() {
        toast(R.string.error_movie_detail)
    }
}