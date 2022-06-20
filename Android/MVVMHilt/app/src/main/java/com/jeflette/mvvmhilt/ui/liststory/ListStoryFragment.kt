package com.jeflette.mvvmhilt.ui.liststory

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jeflette.mvvmhilt.R
import com.jeflette.mvvmhilt.databinding.FragmentListStoryBinding

class ListStoryFragment : Fragment() {

    private var _binding :FragmentListStoryBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = ListStoryFragment()
    }

    private lateinit var viewModel: ListStoryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListStoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ListStoryViewModel::class.java)
        // TODO: Use the ViewModel
    }

}