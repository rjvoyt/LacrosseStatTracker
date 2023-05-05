package com.example.lacrossestattracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lacrossestattracker.databinding.FragmentPlayersBinding
import androidx.fragment.app.viewModels

class PlayersFragment : Fragment() {
    private var _binding: FragmentPlayersBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPlayersBinding.inflate(inflater, container, false)
        val rootView = binding.root
        val viewModel: LaxViewModel by viewModels()
        binding.addPlayerButton.setOnClickListener {
            val mAdapter = PlayersAdapter(viewModel.currentPlayerList)
            binding.playersRecyclerView.adapter = mAdapter
        }
        return rootView
    }

}