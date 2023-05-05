package com.example.lacrossestattracker

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lacrossestattracker.databinding.ListTeamLayoutBinding

class TeamsAdapter(val teamList: List<Team>): RecyclerView.Adapter<TeamsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamsViewHolder {
        val binding = ListTeamLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TeamsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TeamsViewHolder, position: Int) {
        val currentTeam = teamList[position]
        holder.bindTeam(currentTeam)
    }

    override fun getItemCount(): Int {
        return teamList.size
    }

}