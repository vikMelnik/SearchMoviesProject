package come.geekbrains.vitekm.searchmovies.model.rest_entities


data class MoviesDTO(
    val id: String?,
    val title: String,
    val imDbRatingCount: String?,
    val fullTitle: String?,
    val imDbRating: String?,
    val year: String,
    val image: String,
    val crew: String?
)
