package com.jeflette.storyapps.ui.addstory

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jeflette.storyapps.R

class AddStory : Fragment() {

    companion object {
        fun newInstance() = AddStory()
    }

    private lateinit var viewModel: AddStoryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_story, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AddStoryViewModel::class.java)
        // TODO: Use the ViewModel
    }

}