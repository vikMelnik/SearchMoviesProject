package come.geekbrains.vitekm.searchmovies.services

import android.app.IntentService
import android.content.Intent
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.google.gson.Gson
import come.geekbrains.vitekm.searchmovies.model.Movie
import come.geekbrains.vitekm.searchmovies.model.rest_entities.MoviesDTO
import come.geekbrains.vitekm.searchmovies.model.rest_entities.MoviesTop250Data
import come.geekbrains.vitekm.searchmovies.ui.main.*
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.MalformedURLException
import java.net.URL
import java.util.stream.Collectors
import javax.net.ssl.HttpsURLConnection


private const val REQUEST_GET = "GET"
private const val REQUEST_TIMEOUT = 10000
private const val REQUEST_API_KEY = "apiKey"
class MainListServices(name: String = "MainListServices") :IntentService(name) {

    private val broadcastIntent = Intent(LIST_INTENT_FILTER)

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onHandleIntent(intent: Intent?) {
        if (intent == null) {
            onEmptyIntent()
        } else {

            loadMovies()
        }
    }


    @RequiresApi(Build.VERSION_CODES.N)
    fun loadMovies() {

        try {
            val uri = URL("https://imdb-api.com/en/API/Top250Movies/k_xtdh6plc")
            lateinit var urlConnection: HttpsURLConnection
            try {
                var urlConnection = uri.openConnection() as HttpsURLConnection
                urlConnection.apply {
                    requestMethod = REQUEST_GET
                    readTimeout = REQUEST_TIMEOUT
                    addRequestProperty(
                        REQUEST_API_KEY,
                        "k_xtdh6plc"
                    )
                }
                val moviesTop250Data: MoviesTop250Data =
                    Gson().fromJson(
                        getLines(BufferedReader(InputStreamReader(urlConnection.inputStream))),
                        MoviesTop250Data::class.java
                    )
                onResponse(moviesTop250Data)
            } catch (e: Exception) {
                onErrorRequest(e.message ?: "Empty error")
            } finally {
                urlConnection.disconnect()
            }
        } catch (e: MalformedURLException) {
            onMalformedURL()
        }
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun getLines(reader: BufferedReader): String {
        return reader.lines().collect(Collectors.joining("\n"))
    }
        private fun onResponse(moviesTop250Data: MoviesTop250Data) {
            val items = moviesTop250Data.items
            if (items == null) {
                onEmptyResponse()
            } else {
                onSuccessResponse()
            }
        }
        private fun onSuccessResponse() {
            putLoadResult(LIST_RESPONSE_SUCCESS_EXTRA)
            LocalBroadcastManager.getInstance(this).sendBroadcast(broadcastIntent)
        }
        private fun onMalformedURL() {
            putLoadResult(LIST_URL_MALFORMED_EXTRA)
            LocalBroadcastManager.getInstance(this).sendBroadcast(broadcastIntent)
        }
        private fun onErrorRequest(error: String) {
            putLoadResult(LIST_REQUEST_ERROR_EXTRA)
            broadcastIntent.putExtra(LIST_REQUEST_ERROR_MESSAGE_EXTRA, error)
            LocalBroadcastManager.getInstance(this).sendBroadcast(broadcastIntent)
        }
        private fun onEmptyResponse() {
            putLoadResult(LIST_RESPONSE_EMPTY_EXTRA)
            LocalBroadcastManager.getInstance(this).sendBroadcast(broadcastIntent)
        }
        private fun onEmptyIntent() {
            putLoadResult(LIST_INTENT_EMPTY_EXTRA)
            LocalBroadcastManager.getInstance(this).sendBroadcast(broadcastIntent)
        }
        private fun onEmptyData() {
            putLoadResult(LIST_DATA_EMPTY_EXTRA)
            LocalBroadcastManager.getInstance(this).sendBroadcast(broadcastIntent)
        }
        private fun putLoadResult(result: String) {
            broadcastIntent.putExtra(LIST_LOAD_RESULT_EXTRA, result)
        }
    }
