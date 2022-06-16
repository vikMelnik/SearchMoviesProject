package come.geekbrains.vitekm.searchmovies.model.repository


import come.geekbrains.vitekm.searchmovies.model.Movie
import come.geekbrains.vitekm.searchmovies.model.getWorldMovies
import come.geekbrains.vitekm.searchmovies.model.rest.MoviesRepo
import come.geekbrains.vitekm.searchmovies.model.rest_entities.MoviesTop250Data


class RepositoryImpl : Repository {

    override fun getMoviesFromServer() = Movie()


    private fun getMoviesFromImdbServerToConvert(movieDTO: MoviesTop250Data): List<Movie> {
        val result = emptyList<Movie>().toMutableList()
        val dto = movieDTO.items
        for (i in dto) {
            val filmItem = Movie(
                i.id.toString(),
                i.title,
                i.imDbRatingCount.toString(),
                i.fullTitle.toString(),
                i.imDbRating.toString(),
                i.year,
                i.image,
                i.crew.toString()
            )
            result.add(filmItem)
        }
        return result
    }

    override fun getMoviesFromImdbServer(): List<Movie> {
        val dto = MoviesRepo.api.getFilmItemListTop250().execute().body()
        return dto?.let { getMoviesFromImdbServerToConvert(it) } ?: emptyList()
    }

    override fun getMoviesFromLocalStorageWorld(): List<Movie> = getWorldMovies()
}
