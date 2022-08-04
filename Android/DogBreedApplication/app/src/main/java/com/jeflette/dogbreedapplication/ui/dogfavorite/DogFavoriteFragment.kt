package com.jeflette.dogbreedapplication.ui.dogfavorite

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jeflette.dogbreedapplication.R

class DogFavoriteFragment : Fragment() {

    companion object {
        fun newInstance() = DogFavoriteFragment()
    }

    private lateinit var viewModel: DogFavoriteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dog_favorite, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DogFavoriteViewModel::class.java)
        // TODO: Use the ViewModel
    }

}