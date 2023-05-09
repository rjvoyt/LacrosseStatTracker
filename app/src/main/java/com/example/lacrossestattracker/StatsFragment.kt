package com.example.lacrossestattracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.lacrossestattracker.databinding.FragmentStatsBinding


class StatsFragment : Fragment() {
    private var _binding: FragmentStatsBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStatsBinding.inflate(inflater, container, false)
        val rootView = binding.root
        val viewModel: LaxViewModel by viewModels()
        binding.assistsNum.text = viewModel.currentPlayerAssists.toString()
        binding.goalsNum.text = viewModel.currentPlayerGoals.toString()
        binding.groundBallsNum.text = viewModel.currentPlayerGroundBalls.toString()
        binding.savesNum.text = viewModel.currentPlayerSaves.toString()
        binding.plusButtonGoals.setOnClickListener {
            viewModel.editGoal(1)
            binding.goalsNum.text = viewModel.currentPlayerGoals.toString()
        }
        binding.minusButtonGoals.setOnClickListener {
            viewModel.editGoal(-1)
            binding.goalsNum.text = viewModel.currentPlayerGoals.toString()
        }
        binding.plusButtonAssists.setOnClickListener {
            viewModel.editAssist(1)
            binding.assistsNum.text = viewModel.currentPlayerAssists.toString()
        }
        binding.minusButtonAssists.setOnClickListener {
            viewModel.editAssist(-1)
            binding.assistsNum.text = viewModel.currentPlayerAssists.toString()
        }
        binding.plusButtonGroundBalls.setOnClickListener {
            viewModel.editGroundBall(1)
            binding.groundBallsNum.text = viewModel.currentPlayerGroundBalls.toString()
        }
        binding.minusButtonGroundBalls.setOnClickListener {
            viewModel.editGroundBall(-1)
            binding.groundBallsNum.text = viewModel.currentPlayerGroundBalls.toString()
        }
        binding.plusButtonSaves.setOnClickListener {
            viewModel.editSave(1)
            binding.savesNum.text = viewModel.currentPlayerSaves.toString()
        }
        binding.minusButtonSaves.setOnClickListener {
            viewModel.editSave(-1)
            binding.savesNum.text = viewModel.currentPlayerSaves.toString()
        }
        return rootView
    }
}