package com.jeflette.mvvmhilt.ui.liststory

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jeflette.mvvmhilt.R

class ListStoryFragment : Fragment() {

    companion object {
        fun newInstance() = ListStoryFragment()
    }

    private lateinit var viewModel: ListStoryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list_story, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ListStoryViewModel::class.java)
        // TODO: Use the ViewModel
    }

}