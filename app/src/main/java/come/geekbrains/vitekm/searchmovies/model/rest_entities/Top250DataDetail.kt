package come.geekbrains.vitekm.searchmovies.model.rest_entities

data class Top250DataDetail(
    val id: String?,
    val title: String,
    val imDbRatingCount: String?,
    val fullTitle: String?,
    val imDbRating: String?,
    val year: String,
    val crew: String?
)