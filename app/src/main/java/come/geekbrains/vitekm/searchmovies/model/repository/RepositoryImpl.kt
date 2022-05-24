package come.geekbrains.vitekm.searchmovies.model.repository

import come.geekbrains.vitekm.searchmovies.model.Movie
import come.geekbrains.vitekm.searchmovies.model.getWorldMovies

class RepositoryImpl: Repository {
    override fun getMoviesFromServer(): Movie = Movie()

    override fun getMoviesFromLocalStorageWorld(): List<Movie> {
        return getWorldMovies()
    }
}