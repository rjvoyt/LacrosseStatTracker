package com.example.lacrossestattracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.example.lacrossestattracker.databinding.FragmentPlayersBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class PlayersFragment : Fragment() {
    private var _binding: FragmentPlayersBinding? = null
    private val binding get() = _binding!!
    private val viewModel: LaxViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPlayersBinding.inflate(inflater, container, false)
        val rootView = binding.root
        val args = PlayersFragmentArgs.fromBundle(requireArguments())
        viewModel.setCurrentTeam(viewModel.teams[args.position])
        var mAdapter = PlayersAdapter(viewModel.currentPlayerList)
        binding.playersRecyclerView.adapter = mAdapter
        binding.addPlayerButton.setOnClickListener {
            val dialogView =
                LayoutInflater.from(requireContext()).inflate(R.layout.player_dialog_layout, null)
            MaterialAlertDialogBuilder(requireContext())
                .setTitle(R.string.add_player)
                .setView(dialogView)
                .setNegativeButton(R.string.cancel) { dialog, which ->
                }
                .setPositiveButton(R.string.add) { dialog, which ->
                    if (dialogView.findViewById<EditText>(R.id.editTextPlayerFirstName).text.toString().length > 0) {
                        if (dialogView.findViewById<EditText>(R.id.editTextPlayerLastName).text.toString().length > 0) {
                            if (dialogView.findViewById<EditText>(R.id.editTextNumber).text.toString().length > 0) {
                                viewModel.addPlayertoCurrentTeam(
                                    Player(
                                        dialogView.findViewById<EditText>(R.id.editTextPlayerFirstName).text.toString(),
                                        dialogView.findViewById<EditText>(R.id.editTextPlayerLastName).text.toString(),
                                        dialogView.findViewById<EditText>(R.id.editTextNumber).text.toString()
                                            .toInt(),
                                        0, 0, 0, 0
                                    )
                                )
                                mAdapter = PlayersAdapter(viewModel.currentPlayerList)
                                binding.playersRecyclerView.adapter = mAdapter
                            } else {
                                Toast.makeText(
                                    requireContext(),
                                    R.string.must_enter2,
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        } else {
                            Toast.makeText(
                                requireContext(),
                                R.string.must_enter2,
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    } else {
                        Toast.makeText(requireContext(), R.string.must_enter2, Toast.LENGTH_SHORT)
                            .show()
                    }
                }.show()
        }
        return rootView
    }

}