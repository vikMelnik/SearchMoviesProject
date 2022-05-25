package come.geekbrains.vitekm.searchmovies.model

import come.geekbrains.vitekm.searchmovies.R
import java.util.*

data class Movie(
    var id: UUID = UUID.randomUUID(),
    var name: String = "Titanic",
    var director: String = null.toString(),
    var genre: String = null.toString(),
    var rating: Double = 0.0,
    var yearStart: Int = 0,
    var picture: Int = 0,
    var description: Int = R.string.description_titanic)


fun getWorldMovies(): List<Movie> {
    return listOf(
        Movie(UUID.randomUUID(),"Titanic", "Goblin1", "melodrama", 8.3, 1996, R.drawable.imgboats),
        Movie(UUID.randomUUID(),"Tom and Jerry", "goblin2","cartoon", 7.6, 1983, R.drawable.imgcartoon),
        Movie(UUID.randomUUID(),"Star Track", "Goblin3","fantastika", 8.8, 1978, R.drawable.imgspace),
        Movie(UUID.randomUUID(),"Mouse Jerry ", "Goblin4","cartoon", 7.4, 1986, R.drawable.imgcartoon),
        Movie(UUID.randomUUID(),"Pirates", "Goblin5", "adventure", 8.3,2016, R.drawable.imgboats),
        Movie(UUID.randomUUID(),"Space", "Goblin6","fantastika", 6.8, 2006, R.drawable.imgspace),

        )
}