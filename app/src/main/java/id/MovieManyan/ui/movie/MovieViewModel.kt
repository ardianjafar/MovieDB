package id.MovieManyan.ui.movie

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import id.MovieManyan.data.remote.MovieRepository

class MovieViewModel @ViewModelInject constructor(private val repository: MovieRepository) : ViewModel() {
    val movies = repository.getNowPlayingMovies()
}