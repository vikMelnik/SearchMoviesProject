package come.geekbrains.vitekm.searchmovies.model.repository

import come.geekbrains.vitekm.searchmovies.model.Movie

interface Repository {

    fun getMoviesFromServer(): Movie
    fun getMoviesFromImdbServer(): List<Movie>
    fun getMoviesFromLocalStorageWorld(): List<Movie>
}