package com.jeflette.dogbreedapplication.ui.doglist

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jeflette.dogbreedapplication.R
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DogListFragment : Fragment() {

    companion object {
        fun newInstance() = DogListFragment()
    }

    private lateinit var viewModel: DogListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dog_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DogListViewModel::class.java)
        // TODO: Use the ViewModel
    }

}