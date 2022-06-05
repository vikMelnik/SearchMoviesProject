package come.geekbrains.vitekm.searchmovies.model.repository


import come.geekbrains.vitekm.searchmovies.model.Movie
import come.geekbrains.vitekm.searchmovies.model.MoviesLoader
import come.geekbrains.vitekm.searchmovies.model.getWorldMovies

class RepositoryImpl : Repository {

    override fun getMoviesFromServer(): Movie {
        val dto = MoviesLoader.loadMovies()
        return Movie(
            id = dto?.items?.id ?: " ",
            name = dto?.items?.title ?: " ",
            imDbRatingCount = dto?.items?.imDbRatingCount ?: "",
            fullTitle = dto?.items?.fullTitle ?: "",
            rating = dto?.items?.imDbRating ?: "",
            yearStart = dto?.items?.year ?: "",
            crew = dto?.items?.crew ?: " "
        )

    }

    override fun getMoviesFromLocalStorageWorld() = getWorldMovies()
}