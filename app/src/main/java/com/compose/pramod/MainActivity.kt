package com.compose.pramod

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.compose.pramod.model.Movie
import com.compose.pramod.ui.theme.pramod
import com.compose.pramod.ui.theme.pramod
import com.compose.pramod.view.MovieItem
import com.compose.pramod.viewModel.MovieViewModel

class MainActivity : ComponentActivity() {

    val movieViewModel by viewModels<MovieViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            pramod {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    MovieList(movieList = movieViewModel.movieListResponse)
                    movieViewModel.getMovieList()

                }
            }
        }
    }
}

@Composable
fun MovieList(movieList: List<Movie>) {
    LazyColumn {
        itemsIndexed(items = movieList) { index, item ->
            MovieItem(movie = item)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    pramod {
        val movie = Movie(
            "Coco",
            "https://howtodoandroid.com/images/coco.jpg",
            "Coco is a 2017 American 3D computer-animated musical fantasy adventure film produced by Pixar",
            "Latest"
        )

        MovieItem(movie = movie)

    }
}