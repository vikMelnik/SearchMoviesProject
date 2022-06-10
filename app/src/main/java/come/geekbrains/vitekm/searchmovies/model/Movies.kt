package come.geekbrains.vitekm.searchmovies.model

import android.os.Parcelable
import come.geekbrains.vitekm.searchmovies.R
import kotlinx.parcelize.Parcelize


@Parcelize
data class Movie(
    var id: String = " ",
    var name: String = " ",
    var imDbRatingCount: String = " ",
    var fullTitle: String = " ",
    var rating: String = "0.0",
    var yearStart: String = "Date of start: 2017",
    var picture: Int = R.drawable.moviescr,
    var crew: String = " "
) : Parcelable


fun getWorldMovies() = listOf(
    Movie(
        "tt0111161",
        "The\n" +
                "Shawshank Redemption",
        "1592922",
        " The Shawshank" +
                "                \"Redemption\n" +
                "                \"(1994)",
        "8.3",
        "Date of start: 2017",
        R.drawable.moviescr,
        "rrrrrrrrrrrr"
    ),
    Movie(
        "tt0068646", "The\n" +
                "Godfather", "2", " Godfather", "7.6", "Date of start: 1983", R.drawable.moviescr
    ),
    Movie(
        "tt0468569",
        "The Dark\n" +
                "Knight",
        "Directors: Goblin3",
        " fantastika",
        "8.8",
        "Date of start: 1978",
        R.drawable.moviescr,
        "111111111111"
    ),
    Movie(
        "tt0071562",
        "The Godfather:\n" +
                "Part II",
        "Directors: Goblin4",
        " cartoon",
        "7.4",
        "Date of start: 1986",
        R.drawable.moviescr
    ),
    Movie(
        "tt0050083",
        "12 Angry\n" +
                "Men",
        "Directors: Goblin5",
        " adventure",
        "8.3",
        "Date of start: 2016",
        R.drawable.moviescr
    ),
    Movie(
        "tt0108052",
        "Schindler's\n" +
                "List",
        "Directors: Goblin6",
        " fantastika",
        "6.8",
        "Date of start: 2006",
        R.drawable.moviescr,
        "R.string.description_titanic"
    ),
)
