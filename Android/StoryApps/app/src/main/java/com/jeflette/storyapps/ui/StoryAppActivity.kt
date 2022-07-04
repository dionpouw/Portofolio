package com.jeflette.storyapps.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jeflette.storyapps.databinding.ActivityStoryAppApplicationBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StoryAppActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStoryAppApplicationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityStoryAppApplicationBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

}