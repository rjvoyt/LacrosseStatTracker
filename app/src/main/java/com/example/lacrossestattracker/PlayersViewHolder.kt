package com.example.lacrossestattracker

import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.lacrossestattracker.databinding.ListPlayerLayoutBinding


class PlayersViewHolder(val binding: ListPlayerLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
    private lateinit var currentPlayer: Player
    init {
        binding.root.setOnClickListener {
            val action = PlayersFragmentDirections.actionPlayersFragmentToStatsFragment()
            binding.root.findNavController().navigate(action)
        }
    }
    fun bindPlayer(player: Player) {
        currentPlayer = player
        binding.playerNameTextView.text = "${currentPlayer.firstName} ${currentPlayer.lastName}"
        binding.playerNumberTextView.text = "#${currentPlayer.number}"
    }
}