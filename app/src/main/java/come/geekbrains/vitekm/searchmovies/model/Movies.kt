package come.geekbrains.vitekm.searchmovies.model

import come.geekbrains.vitekm.searchmovies.R

data class Movie(
    var name: String = "Titanic",
    var director: String = null.toString(),
    var year: Int = 0,
    var picture: Int = 0)

fun getWorldMovies(): List<Movie> {
    return listOf(
        Movie("Titanic", "Goblin1", 1996, R.drawable.imgboats),
        Movie("Tom and Jerry", "goblin2", 1983, R.drawable.imgcartoon),
        Movie("Star Track", "Goblin3", 1978, R.drawable.imgspace),
        Movie("Mouse Jerry ", "Goblin4", 1986, R.drawable.imgcartoon),
        Movie("Pirates", "Goblin5", 2016, R.drawable.imgboats),
        Movie("Space", "Goblin6", 2006, R.drawable.imgspace),

        )
}