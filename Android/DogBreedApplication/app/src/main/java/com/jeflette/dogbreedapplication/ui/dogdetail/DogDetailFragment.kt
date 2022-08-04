package com.jeflette.dogbreedapplication.ui.dogdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.jeflette.dogbreedapplication.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DogDetailFragment : Fragment() {

    companion object {
        fun newInstance() = DogDetailFragment()
    }

    private lateinit var viewModel: DogDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dog_detail, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DogDetailViewModel::class.java)
        // TODO: Use the ViewModel
    }

}