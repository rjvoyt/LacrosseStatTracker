package com.example.lacrossestattracker

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lacrossestattracker.databinding.ListPlayerLayoutBinding

class PlayersAdapter(val playerList: List<Player>): RecyclerView.Adapter<PlayersViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayersViewHolder {
        val binding = ListPlayerLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PlayersViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlayersViewHolder, position: Int) {
        val currentPlayer = playerList[position]
        holder.bindPlayer(currentPlayer, position)
    }

    override fun getItemCount(): Int {
        return playerList.size
    }

}