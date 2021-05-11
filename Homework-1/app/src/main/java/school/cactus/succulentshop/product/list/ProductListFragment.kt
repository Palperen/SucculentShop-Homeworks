package school.cactus.succulentshop.product.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager.VERTICAL
import school.cactus.succulentshop.R
import school.cactus.succulentshop.databinding.FragmentProductListBinding

class ProductListFragment: Fragment(){

    private var _binding: FragmentProductListBinding? = null

    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProductListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity().title = getString(R.string.app_name)

        binding.recyclerView.adapter = ProductAdapter()
        binding.recyclerView.layoutManager = StaggeredGridLayoutManager(2, VERTICAL)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}