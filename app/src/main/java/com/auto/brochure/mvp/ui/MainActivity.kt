package com.auto.brochure.mvp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import ca.harneev.*
import ca.harneev.databinding.FragmentMainBinding
import com.auto.brochure.mvp.*
import com.auto.brochure.mvp.contract.Presenter
import com.auto.brochure.mvp.contract.ViewContract
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add<MainFragment>(R.id.fragment_container_view)
        }
    }

}

/**
 * This fragment implements Restartable Lifecycle-aware coroutines
 *
 * @see [https://developer.android.com/topic/libraries/architecture/coroutines#restart]
 */
class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    private val view = object : ViewContract {

        val bindingInterface = object : GenericRecyclerBindingInterface<CarMake> {
            override fun bindData(item: CarMake, textView: TextView) {
                textView.text = item.name
            }
        }

        override fun displayCarManufacturers(list: List<CarMake>) {
            binding.recyclerView.apply {
                val linearLayoutManager = LinearLayoutManager(requireContext())
                layoutManager = linearLayoutManager
                adapter = RecyclerAdapter(
                    displayList = list,
                    bindingInterface
                )
                addItemDecoration(
                    DividerItemDecoration(
                        requireContext(),
                        linearLayoutManager.orientation
                    )
                )
            }
        }

        override fun displayModelsOfBrand(manufacturerCode: String, list: List<MakeModel>) {
            // do nothing
        }

        override fun displayModelTrims(modelCode: Int, list: List<ModelTrim>) {
            // do nothing
        }

        override fun displayTrimDetails(trimCode: String, list: List<TrimDetails>) {
            // do nothing
        }

        override fun showError(errorMessage: String) {
            Toast.makeText(requireActivity(), errorMessage, Toast.LENGTH_LONG).show()
        }
    }

    private val model = AppDI.provideModel()

    private val presenter = Presenter(view, model)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        viewLifecycleOwner.lifecycleScope.launch {
            presenter.getCarManufacturersList()
        }
    }
}
