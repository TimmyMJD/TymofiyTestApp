package com.adgif.timofiytestapp.ui.view

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.*
import com.adgif.timofiytestapp.R
import com.adgif.timofiytestapp.base.extension.dpToPx
import com.adgif.timofiytestapp.ui.model.GifUIModel
import com.adgif.timofiytestapp.ui.view.adapter.MainAdapter
import com.adgif.timofiytestapp.ui.view_model.MainViewModel
import com.google.android.material.divider.MaterialDividerItemDecoration
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
            layoutManager = GridLayoutManager(requireContext(), 2)
            addItemDecoration(
                MaterialDividerItemDecoration(
                    context,
                    MaterialDividerItemDecoration.HORIZONTAL
                ).also {
                    it.dividerThickness = dpToPx(8).toInt()
                    it.dividerColor = ContextCompat.getColor(context, R.color.purple_200)
                })
            addItemDecoration(
                MaterialDividerItemDecoration(
                    context,
                    MaterialDividerItemDecoration.VERTICAL
                ).also {
                    it.dividerThickness = dpToPx(8).toInt()
                    it.dividerColor = ContextCompat.getColor(context, R.color.purple_200)
                })
            adapter = myAdapter
            addOnScrollListener(object : RecyclerView.OnScrollListener() {

                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    val layoutManager = recyclerView.layoutManager as GridLayoutManager
                    val visibleItemCount = layoutManager.childCount
                    val totalItemCount = layoutManager.itemCount
                    val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()
                    if (!viewModel.isLoading() && !viewModel.isLastPage()) {
                        if (visibleItemCount + firstVisibleItemPosition >= totalItemCount &&
                            firstVisibleItemPosition >= 0 &&
                            totalItemCount >= viewModel.getPageSize()
                        ) {
                            viewModel.loadMore()
                        }
                    }
                }
            })
        }

        viewModel.dataLiveData.observe(viewLifecycleOwner) {
            updateData(it)
        }
    }

    private fun updateData(list: List<GifUIModel>) {
        (recyclerView.adapter as? MainAdapter)?.submitList(list)
    }

}