package app.practice.epoxy.example2

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import app.practice.epoxy.R
import app.practice.epoxy.databinding.Example2FragmentBinding
import app.practice.epoxy.example2.epoxy.banner
import kotlinx.coroutines.delay

class example2Fragment : Fragment() {

    companion object {
        fun newInstance() = example2Fragment()
    }

    private lateinit var viewModel: Example2ViewModel
    private var _binding: Example2FragmentBinding? = null
    private val binding get() = _binding!!

    private lateinit var controller: Controller

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DataBindingUtil.inflate(inflater, R.layout.example2_fragment, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(Example2ViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()

    }

    private fun setupRecyclerView() {

        controller = Controller().apply {
            megaBanner = DataSourceExample2.getMegaBanner()
            horizontalBanners = DataSourceExample2.getHorizontalBanners()
            categories = DataSourceExample2.getCategories()
            productItems = DataSourceExample2.getPromotionProducts()
        }

        binding.recView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(false)
            setController(controller)
        }

    }

}