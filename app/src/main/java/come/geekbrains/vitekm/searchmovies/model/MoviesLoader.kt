package come.geekbrains.vitekm.searchmovies.model

import android.os.Build
import androidx.annotation.RequiresApi
import com.google.gson.Gson
import come.geekbrains.vitekm.searchmovies.model.rest_entities.MoviesDTO
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL
import java.util.stream.Collectors
import javax.net.ssl.HttpsURLConnection

object MoviesLoader {
    fun loadMovies(): MoviesDTO? {
        val uri = URL("https://imdb-api.com/en/API/Top250Movies/k_xtdh6plc")
        lateinit var urlConnection: HttpsURLConnection

        return try {
            urlConnection = uri.openConnection() as HttpsURLConnection
            urlConnection.requestMethod = "GET"
            urlConnection.addRequestProperty(
                "apiKey", "k_xtdh6plc"
            )
            urlConnection.readTimeout = 10000
            val bufferedReader = BufferedReader(InputStreamReader(urlConnection.inputStream))
            // преобразование ответа от сервера (JSON) в модель данных (WeatherDTO)
            val lines = if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
                getLinesForOld(bufferedReader)
            } else {
                getLines(bufferedReader)
            }

            Gson().fromJson(lines,MoviesDTO::class.java)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        } finally {
            urlConnection.disconnect()
        }
    }

    private fun getLinesForOld(reader: BufferedReader): String {
        val rawData = StringBuilder(1024)
        var tempVariable: String?

        while (reader.readLine().also { tempVariable = it } != null) {
            rawData.append(tempVariable).append("\n")
        }

        reader.close()
        return rawData.toString()
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun getLines(reader: BufferedReader): String {
        return reader.lines().collect(Collectors.joining("\n"))
    }
}