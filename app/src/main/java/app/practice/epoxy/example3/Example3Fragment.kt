package app.practice.epoxy.example3

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import app.practice.epoxy.R
import app.practice.epoxy.databinding.Example2FragmentBinding
import app.practice.epoxy.databinding.Example3FragmentBinding
import app.practice.epoxy.example3.di.Injector
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest

class Example3Fragment : Fragment() {

    private lateinit var viewModel: Example3ViewModel
    private val uiPagedListController by lazy {
        UIPagedListController(
            onLoadSuccess
        )
    }

    private var _binding: Example3FragmentBinding? = null
    private val binding get() = _binding!!

    private var isRefresh = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = Example3FragmentBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this@Example3Fragment
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val fakeApi = Injector.provideFakeApi()
        val fakeRepository = Injector.provideFakeRepository(fakeApi)
        val factory = Example3ViewModel.Factory(fakeRepository)

        viewModel = ViewModelProvider(this, factory).get(Example3ViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeViewModel()
        initWidget()
        initListener()
    }

    private fun initListener() {
        binding.swipeRefreshLayout.setOnRefreshListener {
            isRefresh = true
            uiPagedListController.refresh()
        }
    }

    private fun initWidget() {
        binding.progressBar.visibility = View.VISIBLE

        binding.example3RecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = uiPagedListController.adapter
        }
    }

    private fun observeViewModel() {
        println("modelsmodelsmodelsmodelsmodels start")

        lifecycleScope.launchWhenStarted {
            viewModel.getPagingData().collectLatest { data ->
                println("modelsmodelsmodelsmodelsmodels done")
                uiPagedListController.submitData(data)

                if (isRefresh) {
                    binding.swipeRefreshLayout.isRefreshing = false
                }
            }
        }
    }

    private fun hideLoading() {
        lifecycleScope.launchWhenStarted {
//            delay(1000L)
            binding.progressBar.visibility = View.GONE
            println("modelsmodelsmodelsmodelsmodels hideLoading")
        }
    }

    private val onLoadSuccess = {
        hideLoading()
    }

}