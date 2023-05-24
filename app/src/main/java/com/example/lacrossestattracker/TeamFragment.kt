package com.example.lacrossestattracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import com.example.lacrossestattracker.databinding.FragmentTeamBinding
import androidx.fragment.app.viewModels
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
        var mAdapter = TeamsAdapter(viewModel.teams)
        binding.teamsRecyclerView.adapter = mAdapter
        binding.addTeamButton.setOnClickListener {
            val dialogView =
                LayoutInflater.from(requireContext()).inflate(R.layout.team_dialog_layout, null)
            MaterialAlertDialogBuilder(requireContext())
                .setTitle(R.string.add_team)
                .setView(dialogView)
                .setNegativeButton(R.string.cancel) { dialog, which ->
                }
                .setPositiveButton(R.string.add) { dialog, which ->
                    if (dialogView.findViewById<EditText>(R.id.editTextTeamName).text.toString().length > 0) {
                        viewModel.addTeam(
                            Team(
                                dialogView.findViewById<EditText>(R.id.editTextTeamName).text.toString(),
                                mutableListOf<Player>()
                            )
                        )
                        mAdapter = TeamsAdapter(viewModel.teams)
                        binding.teamsRecyclerView.adapter = mAdapter
                    } else {
                        Toast.makeText(requireContext(), R.string.must_enter, Toast.LENGTH_SHORT)
                            .show()
                    }
                }.show()
        }
        return rootView
    }
}