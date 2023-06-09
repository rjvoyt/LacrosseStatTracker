package com.example.lacrossestattracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.example.lacrossestattracker.databinding.FragmentTeamBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class TeamFragment : Fragment() {
    private var _binding: FragmentTeamBinding? = null
    private val binding get() = _binding!!
    private val viewModel: LaxViewModel by activityViewModels()
    lateinit var dbRef: DatabaseReference
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTeamBinding.inflate(inflater, container, false)
        val rootView = binding.root
        dbRef = Firebase.database.reference
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
                        mAdapter.notifyDataSetChanged()
                    } else {
                        Toast.makeText(requireContext(), R.string.must_enter, Toast.LENGTH_SHORT)
                            .show()
                    }
                }.show()
        }
        return rootView
    }
}