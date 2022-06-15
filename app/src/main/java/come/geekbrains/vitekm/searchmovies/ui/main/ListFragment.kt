package come.geekbrains.vitekm.searchmovies.ui.main

//import android.content.BroadcastReceiver
//import android.content.Context
//import android.content.Intent
//import android.content.IntentFilter
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.fragment.app.Fragment
//import androidx.lifecycle.Observer
//import androidx.localbroadcastmanager.content.LocalBroadcastManager
//import com.google.android.material.snackbar.Snackbar
//import come.geekbrains.vitekm.searchmovies.R
//import come.geekbrains.vitekm.searchmovies.databinding.MainFragmentBinding
//import come.geekbrains.vitekm.searchmovies.model.AppState
//import come.geekbrains.vitekm.searchmovies.model.Movie
//import come.geekbrains.vitekm.searchmovies.ui.adapters.MainFragmentAdapter
//import come.geekbrains.vitekm.searchmovies.ui.details.DetailsFragment
//import org.koin.androidx.viewmodel.ext.android.viewModel
//
//const val LIST_INTENT_FILTER = "LIST INTENT FILTER"
//const val LIST_LOAD_RESULT_EXTRA = "LOAD RESULT"
//const val LIST_INTENT_EMPTY_EXTRA = "INTENT IS EMPTY"
//const val LIST_DATA_EMPTY_EXTRA = "DATA IS EMPTY"
//const val LIST_RESPONSE_EMPTY_EXTRA = "RESPONSE IS EMPTY"
//const val LIST_REQUEST_ERROR_EXTRA = "REQUEST ERROR"
//const val LIST_REQUEST_ERROR_MESSAGE_EXTRA = "REQUEST ERROR MESSAGE"
//const val LIST_URL_MALFORMED_EXTRA = "URL MALFORMED"
//const val LIST_RESPONSE_SUCCESS_EXTRA = "RESPONSE SUCCESS"
//private const val PROCESS_ERROR = "Обработка ошибки"
//
//class ListFragment : Fragment() {
//    private val viewModel: MainViewModel by viewModel()
//    private var _binding: MainFragmentBinding? = null
//    private val binding get() = _binding!!
//
//    private var adapter: MainFragmentAdapter? = null
//
//    private val loadResultsReceiver: BroadcastReceiver = object :
//        BroadcastReceiver() {
//        override fun onReceive(context: Context, intent: Intent) {
//            when (intent.getStringExtra(LIST_LOAD_RESULT_EXTRA)) {
//                LIST_INTENT_EMPTY_EXTRA -> TODO(PROCESS_ERROR)
//                LIST_DATA_EMPTY_EXTRA -> TODO(PROCESS_ERROR)
//                LIST_RESPONSE_EMPTY_EXTRA -> TODO(PROCESS_ERROR)
//                LIST_REQUEST_ERROR_EXTRA -> TODO(PROCESS_ERROR)
//                LIST_REQUEST_ERROR_MESSAGE_EXTRA -> TODO(PROCESS_ERROR)
//                LIST_URL_MALFORMED_EXTRA -> TODO(PROCESS_ERROR)
//                LIST_RESPONSE_SUCCESS_EXTRA -> renderData(
//                    appState = AppState.Success(moviesFromImdbServer = listOf())
//                )
//                else -> TODO(PROCESS_ERROR)
//            }
//        }
//    }
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        context?.let {
//            LocalBroadcastManager.getInstance(it)
//                .registerReceiver(
//                    loadResultsReceiver,
//                    IntentFilter(LIST_INTENT_FILTER)
//                )
//        }
//    }
//
//    override fun onDestroy() {
//        context?.let {
//            LocalBroadcastManager.getInstance(it).unregisterReceiver(loadResultsReceiver)
//        }
//        super.onDestroy()
//    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle
//        ?
//    )
//            : View {
//        _binding = MainFragmentBinding.inflate(inflater, container, false)
//        return binding.root
//    }
//
//    override fun onViewCreated(
//        view: View, savedInstanceState: Bundle?
//    ) {
//        super.onViewCreated(view, savedInstanceState)
//        with(binding) {
//            mainFragmentRecyclerView.adapter = adapter
//
//            val observer = Observer<AppState> { renderData(it) }
//            viewModel.liveData.observe(viewLifecycleOwner, observer)
//            //viewModel.getMoviesFromLocalSourceWorld()
//            viewModel.getMoviesFromImdbServer()
//        }
//
//    }
//
//    private fun renderData(appState: AppState) = with(binding) {
//        when (appState) {
//            is AppState.Success -> {
//                progressBar.visibility = View.GONE
//                adapter = MainFragmentAdapter(object :
//                    OnItemViewClickListener { //????????
//                    override fun onItemViewClick(movie: Movie) {
//                        val manager = activity?.supportFragmentManager
//                        manager?.let { manager ->
//                            val bundle = Bundle().apply {
//                                putParcelable(
//                                    DetailsFragment.BUNDLE_EXTRA,
//                                    movie
//                                )
//                            }
//                            manager.beginTransaction()
//                                .replace(
//                                    R.id.container,
//                                    DetailsFragment.newInstance(bundle)
//                                )
//                                .addToBackStack("")
//                                .commitAllowingStateLoss()
//                        }
//                    }
//                }).apply {
//                    setMovies(appState.moviesFromImdbServer)
//                    //setMovies(appState.moviesData)
//                }
//                mainFragmentRecyclerView.adapter = adapter
//            }
//            is AppState.Loading -> {
//                progressBar.visibility = View.VISIBLE
//            }
//            is AppState.Error -> {
//                progressBar.visibility = View.GONE
//
//                mainFragmentRootView.showSnackBar(
//                    getString(R.string.error),
//                    getString(R.string.reload),
//                    { viewModel.getMoviesFromLocalSourceWorld() })
//
//            }
//        }
//    }
//
//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }
//
//    interface OnItemViewClickListener {
//
//        fun onItemViewClick(movie: Movie)
//
//    }
//
//    companion object {
//        fun newInstance() = ListFragment()
//    }
//}
//
//private fun View.showSnackBar(
//    text: String,
//    actionText: String,
//    action: (View) -> Unit,
//    length: Int = Snackbar.LENGTH_INDEFINITE
//) {
//    Snackbar.make(this, text, length).setAction(actionText, action).show()
//}