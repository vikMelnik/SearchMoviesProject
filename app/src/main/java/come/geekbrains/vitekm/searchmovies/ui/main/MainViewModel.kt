package come.geekbrains.vitekm.searchmovies.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import come.geekbrains.vitekm.searchmovies.model.AppState
import come.geekbrains.vitekm.searchmovies.model.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository) : ViewModel() {
    private val localLiveData = MutableLiveData<AppState>()
    val liveData: LiveData<AppState> get() = localLiveData

    fun getMoviesFromLocalSourceWorld() = getDataFromLocalSource()
    fun getMoviesFromServer() = getDataFromLocalSource()
    fun getMoviesFromImdbServer() = getDataFromLocalSource()

    private fun getDataFromLocalSource() {
        localLiveData.value = AppState.Loading
        viewModelScope.launch(Dispatchers.IO){
            val data = repository.getMoviesFromImdbServer()
            localLiveData.postValue(AppState.Success(data))
        }
//        Thread {
//            Thread.sleep(1000)
//            localLiveData.postValue(
//
//                AppState.Success(
//                    repository.getMoviesFromLocalStorageWorld(),
//                    repository.getMoviesFromImdbServer()
//                )
//            )
//
//        }.start()
    }
}