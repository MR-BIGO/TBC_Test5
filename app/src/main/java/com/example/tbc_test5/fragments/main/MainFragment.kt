package com.example.tbc_test5.fragments.main

import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tbc_test5.BaseFragment
import com.example.tbc_test5.adapters.HorizontalNewRecyclerAdapter
import com.example.tbc_test5.adapters.VerticalActiveRecyclerAdapter
import com.example.tbc_test5.databinding.FragmentMainBinding
import kotlinx.coroutines.launch

class MainFragment : BaseFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {

    private val viewModel: MainFragmentViewModel by viewModels()
    private lateinit var newCourseAdapter: HorizontalNewRecyclerAdapter
    private lateinit var activeCourseAdapter: VerticalActiveRecyclerAdapter

    override fun setUp() {
        setUpRvs()
        bindObservers()
    }

    private fun setUpRvs() {
        with(binding) {
            rvHorizontalNew.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            rvVerticalActive.layoutManager = LinearLayoutManager(context)

            newCourseAdapter = HorizontalNewRecyclerAdapter()
            activeCourseAdapter = VerticalActiveRecyclerAdapter()

            rvHorizontalNew.adapter = newCourseAdapter
            rvVerticalActive.adapter = activeCourseAdapter
        }
    }

    private fun bindObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    viewModel.activeCoursesList.collect {
                        activeCourseAdapter.submitList(it)
                    }
                }
                launch {
                    viewModel.newCoursesList.collect {
                        newCourseAdapter.submitList(it)
                    }
                }
            }
        }
    }
}