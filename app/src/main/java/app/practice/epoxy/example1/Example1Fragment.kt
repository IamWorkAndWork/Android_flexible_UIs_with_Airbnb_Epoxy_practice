package app.practice.epoxy.example1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import app.practice.epoxy.*
import app.practice.epoxy.databinding.FragmentExample1Binding
import com.airbnb.epoxy.carousel

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class Example1Fragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    private var _binding: FragmentExample1Binding? = null
    private val binding
        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DataBindingUtil.inflate<FragmentExample1Binding>(
            inflater,
            R.layout.fragment_example1,
            container,
            false
        )
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        binding.epoxyRecyclerView.apply {
            withModels {

                // First title
                itemTitle {
                    id("title-id")
                    title("Need Assistant")
                }

                // Carousel Item
                val carouselItemModelList = DataSource.carouselItems.map { item ->
                    ItemTaskCarouselBindingModel_()
                        .id(item.id)
                        .carouselItem(item)
                }

                // Carousel
                // This extension function come with epoxy
                carousel {
                    id("car")
                    models(carouselItemModelList)
                }

                // Task title
                // item_title.xml
                itemTitle {
                    id("title-id")
                    title("Items")
                }

                // Tasks
                DataSource.taskList.forEach { item ->
                    itemTask {
                        id(item.id)
                        task(item)
                        clickListener { v ->

                        }
                    }
                }

            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Example1Fragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}