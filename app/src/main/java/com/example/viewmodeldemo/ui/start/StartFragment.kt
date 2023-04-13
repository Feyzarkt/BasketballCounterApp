package com.example.viewmodeldemo.ui.start

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.viewmodeldemo.R
import com.example.viewmodeldemo.databinding.FragmentStartBinding

class StartFragment : Fragment() {

    private lateinit var binding: FragmentStartBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStartBinding.inflate(inflater)
        // Inflate the layout for this fragment

        initListeners()

        return binding.root
    }

    private fun initListeners(){
        with(binding) {
            btnMatchOne.setOnClickListener {
                findNavController().navigate(StartFragmentDirections.actionStartFragmentToCounterFragment(0))
            }
            btnMatchTwo.setOnClickListener {
                findNavController().navigate(StartFragmentDirections.actionStartFragmentToCounterFragment(1))
            }
            btnMatchThree.setOnClickListener {
                findNavController().navigate(StartFragmentDirections.actionStartFragmentToCounterFragment(2))
            }
        }

    }

}