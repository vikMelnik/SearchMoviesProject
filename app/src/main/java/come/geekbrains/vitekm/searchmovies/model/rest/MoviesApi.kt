package come.geekbrains.vitekm.searchmovies.model.rest

import come.geekbrains.vitekm.searchmovies.model.rest_entities.MoviesTop250Data
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApi {

    @GET(IMDB_TOP_250_MOVIES)
    fun getFilmItemListTop250(@Query("apiKey") apiKey: String = API_KEY): Call<MoviesTop250Data>
}