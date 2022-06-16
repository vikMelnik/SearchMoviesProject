package come.geekbrains.vitekm.searchmovies.model.rest

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MoviesRepo {
    val api: MoviesApi by lazy {
        val adapter = Retrofit.Builder()
            .baseUrl(ApiUtils.baseUrlMain)
            .addConverterFactory(GsonConverterFactory.create())
            .client(ApiUtils.getOkHTTPBuilderWithHeaders())
            .build()

        adapter.create(MoviesApi::class.java)
    }
}