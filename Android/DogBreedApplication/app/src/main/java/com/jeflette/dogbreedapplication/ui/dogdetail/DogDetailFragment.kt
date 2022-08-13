package com.jeflette.dogbreedapplication.ui.dogdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.jeflette.dogbreedapplication.databinding.FragmentDogDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DogDetailFragment : Fragment() {

    private val args: DogDetailFragmentArgs by navArgs()

    private val viewModel: DogDetailViewModel by viewModels()
    private var _binding: FragmentDogDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDogDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.apply {
            Glide.with(this@DogDetailFragment).load(args.breed.image?.url).into(dogImage)
            dogBreedName.text = args.breed.name
            dogBreedWeight.text = args.breed.weight?.metric
            dogBreedLifeSpan.text = args.breed.lifeSpan
            dogBreedTemperament.text = args.breed.temperament

            fab.setOnClickListener {
                viewModel.setDogFavorite(args.breed, !args.breed.isFavorite!!)
            }
        }
    }

    override fun onDetach() {
        super.onDetach()
        _binding = null
    }
}