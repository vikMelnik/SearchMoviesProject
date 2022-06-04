package come.geekbrains.vitekm.searchmovies


import come.geekbrains.vitekm.searchmovies.model.repository.Repository
import come.geekbrains.vitekm.searchmovies.model.repository.RepositoryImpl
import come.geekbrains.vitekm.searchmovies.ui.details.DetailsViewModel
import come.geekbrains.vitekm.searchmovies.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<Repository> { RepositoryImpl() }

    viewModel { MainViewModel(get()) }
    viewModel { DetailsViewModel(get()) }
}