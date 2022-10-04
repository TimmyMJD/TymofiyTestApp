package com.adgif.timofiytestapp.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.adgif.timofiytestapp.R
import com.adgif.timofiytestapp.ui.fragments.adapter.MainAdapter


class MainFragment : Fragment(R.layout.fragment_main) {

    private val viewModel by viewModels<MainViewModel>()
    private lateinit var recyclerView: RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView).apply{
            layoutManager = LinearLayoutManager(requireContext())
            adapter = MainAdapter()
        }
    }

    private fun updateData(list: List<String>){
        (recyclerView.adapter as? MainAdapter)?.submitList(list)
    }

    override fun onResume() {
        super.onResume()
        val mockData = listOf("123", "321", "222")
        updateData(mockData)
    }
}