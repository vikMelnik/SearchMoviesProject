package come.geekbrains.vitekm.searchmovies.model

import android.os.Parcelable
import come.geekbrains.vitekm.searchmovies.R
import kotlinx.parcelize.Parcelize
import java.util.*

@Parcelize
data class Movie(
    var id: UUID = UUID.randomUUID(),
    var name: String = "Titanic",
    var director: String = "Directors: ",
    var genre: String = "Genre: ",
    var rating: Double = 0.0,
    var yearStart: String = "Date of start: 2017",
    var picture: Int = 0,
    var description: Int = R.string.description_titanic)
    :Parcelable


fun getWorldMovies() = listOf(
        Movie(UUID.randomUUID(),"Titanic", "Directors: Goblin1", " melodrama", 8.3,  "Date of start: 2017", R.drawable.imgboats, R.string.description_titanic),
        Movie(UUID.randomUUID(),"Tom and Jerry", "Directors: Goblin2"," cartoon", 7.6, "Date of start: 1983", R.drawable.imgcartoon),
        Movie(UUID.randomUUID(),"Star Track", "Directors: Goblin3"," fantastika", 8.8, "Date of start: 1978", R.drawable.imgspace),
        Movie(UUID.randomUUID(),"Mouse Jerry ", "Directors: Goblin4"," cartoon", 7.4, "Date of start: 1986", R.drawable.imgcartoon),
        Movie(UUID.randomUUID(),"Pirates", "Directors: Goblin5", " adventure", 8.3,"Date of start: 2016", R.drawable.imgboats),
        Movie(UUID.randomUUID(),"Space", "Directors: Goblin6"," fantastika", 6.8, "Date of start: 2006", R.drawable.imgspace,R.string.description_titanic),
        )
