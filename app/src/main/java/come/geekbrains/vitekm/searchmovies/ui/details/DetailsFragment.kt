package come.geekbrains.vitekm.searchmovies.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import come.geekbrains.vitekm.searchmovies.R
import come.geekbrains.vitekm.searchmovies.databinding.DetailFragmentBinding


import come.geekbrains.vitekm.searchmovies.model.Movie

class DetailsFragment : Fragment() {
    private var _binding: DetailFragmentBinding? = null
    private val binding get() = _binding!!

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
            renderData(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun renderData(movie: Movie) {
        with(binding) {
            movieName.text = movie.name
            pictureMovie.setImageResource(movie.picture)
            descriptionMove.text = getString(movie.description)
            director.text = movie.director
            uuid.text = movie.id.toString()

            genre.text = String.format(
                getString(R.string.genre),
                movie.genre
            )
            rating.text = String.format(
                getString(R.string.rating),
                movie.rating.toString()
            )
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