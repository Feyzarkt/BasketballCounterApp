package com.example.viewmodeldemo.ui.counter

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.viewmodeldemo.R
import com.example.viewmodeldemo.databinding.FragmentCounterBinding
import com.example.viewmodeldemo.util.Constants.TEAM_A
import com.example.viewmodeldemo.util.Constants.TEAM_B

class CounterFragment : Fragment() {

    private lateinit var binding: FragmentCounterBinding
    private val args: CounterFragmentArgs by navArgs()

    private val viewModel: CounterViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCounterBinding.inflate(inflater)

        val matchId = args.matchId
        Log.e("Arguments", matchId.toString())

        viewModel.getTeamInfo(matchId)
        initObservers()
        initListeners()

        // Inflate the layout for this fragment
        return binding.root
    }

    private fun initObservers() {
        viewModel.teamInfo.observe(viewLifecycleOwner) {
            with(binding){
                teamOne.text = it.firstTeamName
                teamTwo.text = it.secondTeamName
            }
        }
        viewModel.scoreA.observe(viewLifecycleOwner) {
            binding.scoreOne.text = it.toString()
        }
        viewModel.scoreB.observe(viewLifecycleOwner) {
            binding.scoreTow.text = it.toString()
        }
    }

    private fun initListeners() {
        with(binding){
            leftThreePoints.setOnClickListener {
                viewModel.setThreePoint(TEAM_A)
            }
            rightThreePoints.setOnClickListener {
                viewModel.setThreePoint(TEAM_B)
            }

            leftTwoPoints.setOnClickListener {
                viewModel.setTwoPoint(TEAM_A)
            }
            rightTwoPoints.setOnClickListener {
                viewModel.setTwoPoint(TEAM_B)
            }

            leftFreeThrow.setOnClickListener {
                viewModel.setFreeThrowPoint(TEAM_A)
            }
            rightFreeThrow.setOnClickListener {
                viewModel.setFreeThrowPoint(TEAM_B)
            }

            resetButton.setOnClickListener {
                viewModel.reset()
            }
        }
    }

}