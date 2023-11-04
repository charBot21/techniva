package com.carlostorres.technivamovieapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.carlostorres.technivamovieapp.R
import com.carlostorres.technivamovieapp.common.viewutils.gone
import com.carlostorres.technivamovieapp.common.viewutils.show
import com.carlostorres.technivamovieapp.common.viewutils.toast
import com.carlostorres.technivamovieapp.data.entities.movies.Results
import com.carlostorres.technivamovieapp.databinding.FragmentHomeBinding
import com.carlostorres.technivamovieapp.ui.adapters.MovieAdapter
import com.carlostorres.technivamovieapp.ui.interfaces.MovieListener
import com.carlostorres.technivamovieapp.ui.viewmodel.HomeViewModel

class HomeFragment : Fragment(), MovieListener {

    private val viewModel: HomeViewModel by viewModels()
    private lateinit var movieRecyclerView: RecyclerView
    private lateinit var movieAdapter: MovieAdapter

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel
        viewModel.moviesListener = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager = LinearLayoutManager(context)
        movieRecyclerView = view.findViewById(R.id.moviRecyclerView)
        movieRecyclerView.layoutManager = layoutManager
        movieRecyclerView.setHasFixedSize(true)

        viewModel.getAvailableRefreshObserver().observe(viewLifecycleOwner, Observer {
            if ( it ) {
                viewModel.onGetMovies()
            }
        })

        viewModel.getListObserver().observe(viewLifecycleOwner, Observer {
            if ( it != null ) {
                createRecyclerView(it)
            }
        })

        binding.scrollView.viewTreeObserver.addOnScrollChangedListener {
            val maximumScroll = binding.scrollView.getChildAt(0).height - binding.scrollView.height
            val currentPosition = binding.scrollView.scrollY

            if ( currentPosition == maximumScroll ) {
                viewModel.updateMovieList()
            }
        }
    }

    override fun onError() {
        toast(R.string.error_movie_list)
    }

    private fun createRecyclerView(results: List<Results>) {
        movieAdapter = MovieAdapter(results, this)
        movieRecyclerView.adapter = movieAdapter
    }

    override fun showProgressBar() {
        binding.progress.show()
    }

    override fun hideProgressBar() {
        binding.progress.gone()
    }

    override fun itemClicked(idMovie: Int, position: Int) {
        val directions = HomeFragmentDirections.actionHomeFragmentToMovieDetailFragment(idMovie.toString())
        findNavController().navigate(directions)
    }
}