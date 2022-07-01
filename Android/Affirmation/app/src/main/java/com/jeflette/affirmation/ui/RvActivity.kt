package com.jeflette.affirmation.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.jeflette.affirmation.databinding.ActivityRvBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RvActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    private var _binding: ActivityRvBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityRvBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()

        binding.rvQuotes.layoutManager = LinearLayoutManager(this)

        mainViewModel.result.observe(this) {
            binding.rvQuotes.adapter = RvAdapter(it)
        }
    }

    private fun init() {
        mainViewModel.getAllAffirmation()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}