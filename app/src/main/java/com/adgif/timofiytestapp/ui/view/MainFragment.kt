package com.adgif.timofiytestapp.ui.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.adgif.timofiytestapp.R
import com.adgif.timofiytestapp.ui.view.adapter.MainAdapter
import com.adgif.timofiytestapp.ui.view_model.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainFragment : Fragment(R.layout.fragment_main) {

    private val viewModel by viewModels<MainViewModel>()
    private lateinit var recyclerView: RecyclerView

    @Inject
    lateinit var myAdapter: MainAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView).apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = myAdapter
        }

        viewModel.dataLiveData.observe(viewLifecycleOwner) {
            updateData(it)
        }
    }

    private fun updateData(list: List<String>) {
        (recyclerView.adapter as? MainAdapter)?.submitList(list)
    }

}