package com.example.lacrossestattracker

import android.app.AlertDialog
import android.os.Bundle
import android.text.Layout
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lacrossestattracker.databinding.FragmentTeamBinding
import androidx.fragment.app.viewModels
import com.example.lacrossestattracker.databinding.TeamDialogLayoutBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

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
            val dialogView =
                LayoutInflater.from(requireContext()).inflate(R.layout.team_dialog_layout, null)
            MaterialAlertDialogBuilder(requireContext())
                .setTitle(R.string.add_team)
                .setView(dialogView)
                .setNegativeButton(R.string.cancel) { dialog, which ->
                    dialog.dismiss()
                }
                .setPositiveButton(R.string.add){dialog, which->
                    dialog.dismiss()
                    if(dialogView.)
                    val mAdapter = TeamsAdapter(viewModel.teams)
                    binding.teamsRecyclerView.adapter = mAdapter
                }
        }
        return rootView
    }

}