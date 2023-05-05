package com.example.lacrossestattracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lacrossestattracker.databinding.FragmentTeamBinding
import androidx.fragment.app.viewModels


class TeamFragment : Fragment() {
    private var _binding: FragmentTeamBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTeamBinding.inflate(inflater, container, false)
        val rootView = binding.root
        val viewModel: LaxViewModel by viewModels()
        binding.addTeamButton.setOnClickListener {
            val mAdapter = TeamsAdapter(viewModel.teams)
            binding.teamsRecyclerView.adapter = mAdapter
        }
        return rootView
    }

}