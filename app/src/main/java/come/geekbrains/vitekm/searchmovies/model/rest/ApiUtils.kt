package come.geekbrains.vitekm.searchmovies.model.rest

import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

const val API_KEY = "k_xtdh6plc"
const val IMDB_TOP_250_MOVIES = "Top250Movies"

object ApiUtils {

   const val baseUrlMain = "https://imdb-api.com/en/API/Top250Movies/"

    fun getOkHTTPBuilderWithHeaders(): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
        httpClient.connectTimeout(60, TimeUnit.SECONDS)
        httpClient.readTimeout(60, TimeUnit.SECONDS)
        httpClient.writeTimeout(60, TimeUnit.SECONDS)
        httpClient.addInterceptor { chain ->
            val original = chain.request()
            val request = original.newBuilder()
                .header("apiKey", "k_xtdh6plc")
                .method(original.method, original.body)
                .build()

            chain.proceed(request)
        }

        return httpClient.build()
    }
}