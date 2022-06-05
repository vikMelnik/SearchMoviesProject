package come.geekbrains.vitekm.searchmovies.ui.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import come.geekbrains.vitekm.searchmovies.model.AppState
import come.geekbrains.vitekm.searchmovies.model.repository.Repository

class DetailsViewModel(private val repository: Repository) : ViewModel() {
    private val localLiveData: MutableLiveData<AppState> = MutableLiveData()
    val movieLiveData: LiveData<AppState> get() = localLiveData

    fun loadData() {
        localLiveData.value = AppState.Loading
        Thread {
            val data = repository.getMoviesFromServer()
            localLiveData.postValue(AppState.Success(listOf(data)))
        }.start()
    }
}