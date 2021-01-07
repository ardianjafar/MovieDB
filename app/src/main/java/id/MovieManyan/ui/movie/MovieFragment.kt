package id.MovieManyan.ui.movie

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import id.MovieManyan.R
import id.MovieManyan.databinding.FragmentMovieBinding
import kotlinx.android.synthetic.main.fragment_movie.*

@AndroidEntryPoint
class MovieFragment : Fragment(R.layout.fragment_movie) {
    private val viewModel by viewModels<MovieViewModel>()
    private var _binding : FragmentMovieBinding? = null
    private val binding get() = _binding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentMovieBinding.bind(view)

        val adapter = MovieAdapter()
        binding.apply {
            rv_movie.setHasFixedSize(true)
            rv_movie.adapter = adapter
        }

        viewModel.movies.observe(viewLifecycleOwner) {
            adapter.submitData(viewLifecycleOwner.lifecycle, it)
        }
    }
}