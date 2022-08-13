package com.jeflette.dogbreedapplication.ui.dogfavorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.jeflette.dogbreedapplication.databinding.FragmentDogFavoriteBinding
import com.jeflette.dogbreedapplication.ui.adapter.BaseAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DogFavoriteFragment : Fragment() {

    private val viewModel: DogFavoriteViewModel by viewModels()
    private var _binding: FragmentDogFavoriteBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDogFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val dogsBreedAdapter = BaseAdapter()

        binding.apply {
            recyclerView.apply {
                adapter = dogsBreedAdapter
                layoutManager = LinearLayoutManager(context)
            }
            viewModel.getFavoriteDogs()
            viewModel.dogFavorite.observe(viewLifecycleOwner) {
                dogsBreedAdapter.setItem(it)
            }
        }
    }


    override fun onDetach() {
        super.onDetach()
        _binding = null
    }
}