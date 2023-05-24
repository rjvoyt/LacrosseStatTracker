package com.example.lacrossestattracker

import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.lacrossestattracker.databinding.ListTeamLayoutBinding

class TeamsViewHolder(val binding: ListTeamLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
    private lateinit var currentTeam: Team
    private var currentPosition = 0
    init {
        binding.root.setOnClickListener {
            val action = TeamFragmentDirections.actionTeamFragmentToPlayersFragment()
            binding.root.findNavController().navigate(action)
        }
    }
    fun bindTeam(team: Team, position:Int) {
        currentTeam = team
        binding.teamNameTextView.text = currentTeam.teamName
        currentPosition = position
    }
}