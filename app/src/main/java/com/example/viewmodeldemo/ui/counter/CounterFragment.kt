package com.example.viewmodeldemo.ui.counter

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.viewmodeldemo.R
import com.example.viewmodeldemo.databinding.FragmentCounterBinding

class CounterFragment : Fragment() {

    private lateinit var binding: FragmentCounterBinding
    private val args: CounterFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCounterBinding.inflate(inflater)

        val matchId = args.matchId
        Log.e("Arguments", matchId.toString())

        // Inflate the layout for this fragment
        return binding.root
    }

}