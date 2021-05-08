package app.practice.epoxy

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import app.practice.epoxy.databinding.FragmentMenuBinding
import app.practice.epoxy.example1.Example1Fragment
import com.airbnb.epoxy.Carousel

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class MenuFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    interface MenuFragmentListener {
        fun changeFragment(pos: Int)
    }

    private var listener: MenuFragmentListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is MenuFragmentListener) {
            listener = context
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

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
        val binding = FragmentMenuBinding.inflate(inflater,container,false)
        binding.fragment = this
        return binding.root
    }

    fun changeFragment(pos: Int) {
        listener?.changeFragment(pos)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MenuFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}