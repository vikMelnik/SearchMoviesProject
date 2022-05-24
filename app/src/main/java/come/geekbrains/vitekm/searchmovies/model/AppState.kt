package come.geekbrains.vitekm.searchmovies.model

sealed class AppState {
    data class Success(val moviesData: List<Movie>) : AppState()
    data class Error(val error: Throwable) : AppState()
    object Loading : AppState()
}