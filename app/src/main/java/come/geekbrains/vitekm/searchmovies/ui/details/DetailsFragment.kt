package come.geekbrains.vitekm.searchmovies.ui.details


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import come.geekbrains.vitekm.searchmovies.databinding.DetailFragmentBinding
import come.geekbrains.vitekm.searchmovies.model.AppState
import come.geekbrains.vitekm.searchmovies.model.Movie
import org.koin.androidx.viewmodel.ext.android.viewModel


class DetailsFragment : Fragment() {
    private var _binding: DetailFragmentBinding? = null
    private val binding get() = _binding!!

    private val viewModel: DetailsViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DetailFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getParcelable<Movie>(BUNDLE_EXTRA)?.let {
            renderStaticData(it)
            viewModel.movieLiveData.observe(viewLifecycleOwner) { appState ->
                renderDynamicData(
                    appState
                )
            }
            viewModel.loadData()
        }
    }

    private fun renderDynamicData(appState: AppState) = with(binding) {
        when (appState) {
            is AppState.Error -> {
                mainView.visibility = View.INVISIBLE
                progressBar.visibility = View.GONE
                errorTV.visibility = View.VISIBLE
            }
            AppState.Loading -> {
                mainView.visibility = View.INVISIBLE
                progressBar.visibility = View.VISIBLE
            }
            is AppState.Success -> {
                progressBar.visibility = View.GONE
                mainView.visibility = View.VISIBLE
                descriptionMove.text = appState.moviesData[0].crew
                director.text = appState.moviesData[0].imDbRatingCount
                genre.text = appState.moviesData[0].fullTitle
                rating.text = appState.moviesData[0].rating
                yearDate.text = appState.moviesData[0].yearStart
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun renderStaticData(movie: Movie) {
        with(binding) {
            movieName.text = movie.name

            pictureMovie.setImageResource(movie.picture)

            descriptionMove.text = movie.crew

            director.text = movie.imDbRatingCount

            uuid.text = movie.id

            genre.text = movie.fullTitle

            rating.text = movie.rating

            yearDate.text = movie.yearStart
        }
    }

    companion object {
        const val BUNDLE_EXTRA = "movies"
        fun newInstance(bundle: Bundle): DetailsFragment {
            val fragment = DetailsFragment()
            fragment.arguments = bundle
            return fragment
        }
    }
}


