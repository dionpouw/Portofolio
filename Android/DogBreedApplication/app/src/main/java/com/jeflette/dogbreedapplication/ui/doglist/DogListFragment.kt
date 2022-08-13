package com.jeflette.dogbreedapplication.ui.doglist

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.jeflette.dogbreedapplication.data.local.entity.Breed
import com.jeflette.dogbreedapplication.databinding.FragmentDogListBinding
import com.jeflette.dogbreedapplication.ui.adapter.BaseAdapter
import com.jeflette.dogbreedapplication.util.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DogListFragment : Fragment() {

    private val viewModel: DogListViewModel by viewModels()
    private var _binding: FragmentDogListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDogListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val dogsBreedAdapter = BaseAdapter()

        binding.searchView.setOnQueryTextListener(object :
            SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                viewModel.apply {
                    getBreedSearch(query!!)
                    isLoading.observe(viewLifecycleOwner) { loading ->
                        if (loading) {
                            binding.progressBar.isVisible = true
                        }
                    }
                    breeds.observe(viewLifecycleOwner) { breed ->
                        if (breed != null) {
                            binding.progressBar.isVisible = false
                            val sorted = breed.sortedBy { it.name }
                            dogsBreedAdapter.setItem(Breed.ModelMapper.from(sorted))
                        }
                    }
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })

        binding.apply {
            recyclerView.apply {
                adapter = dogsBreedAdapter
                layoutManager = LinearLayoutManager(context)
            }

            viewModel.dogResponse.observe(viewLifecycleOwner) { dogs ->
                when (dogs) {
                    is Resource.Loading -> {
                        progressBar.isVisible = true
                    }
                    is Resource.Success -> {
                        progressBar.isVisible = false
                        Log.d("Dogs", dogs.toString())
                        dogs.data?.sortedBy { it.name }?.let {
                            dogsBreedAdapter.setItem(it)
                        }
                    }
                    is Resource.Error -> {
                        progressBar.isVisible = false
                        Log.e("Error", dogs.error.toString())
                    }
                }
                progressBar.isVisible = dogs is Resource.Loading && dogs.data.isNullOrEmpty()
                tvEmpty.isVisible = dogs is Resource.Error && dogs.data.isNullOrEmpty()
            }
        }
    }

    override fun onDetach() {
        super.onDetach()
        _binding = null
    }
}