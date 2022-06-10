package come.geekbrains.vitekm.searchmovies.model.repository

import come.geekbrains.vitekm.searchmovies.model.Movie
import come.geekbrains.vitekm.searchmovies.model.MoviesLoader
import come.geekbrains.vitekm.searchmovies.model.getWorldMovies

class RepositoryImpl : Repository {

    override fun getMoviesFromServer() = Movie()

    override fun getMoviesFromImdbServer(): List<Movie> {
        val result = emptyList<Movie>().toMutableList()
        val dto = MoviesLoader.loadMovies()
        dto?.let {
            for (i in dto.items) {
                val filmItem = Movie(
                    i.id.toString(),
                    i.title,
                    i.imDbRatingCount.toString(),
                    i.fullTitle.toString(),
                    i.imDbRating.toString(),
                    i.year,
                    i.image.toInt(),
                    i.crew.toString()
                )
                result.add(filmItem)
            }
        }
        return result
    }

    override fun getMoviesFromLocalStorageWorld(): List<Movie> = getWorldMovies()
}
