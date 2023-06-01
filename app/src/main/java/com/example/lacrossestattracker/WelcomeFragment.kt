package com.example.lacrossestattracker

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.lacrossestattracker.databinding.FragmentWelcomeBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase


class WelcomeFragment : Fragment() {
    lateinit var dbRef: DatabaseReference
    private var _binding: FragmentWelcomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: LaxViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        val rootView = binding.root
        dbRef = Firebase.database.reference
        dbRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val allDBEntries = dataSnapshot.children
                for (allTeamEntries in allDBEntries){
                    for(singleTeamEntry in allTeamEntries.children){
                        val currPlayerList= mutableListOf<Player>()
                        val currTeamName = singleTeamEntry.child("teamName").getValue().toString()
                        for(singlePlayerEntry in singleTeamEntry.child("players").children){
                            val currFirstName = singlePlayerEntry.child("firstName").getValue().toString()
                            val currLastName = singlePlayerEntry.child("lastName").getValue().toString()
                            val currNumber = Integer.parseInt(singlePlayerEntry.child("number").getValue().toString())
                            val currGoals = Integer.parseInt(singlePlayerEntry.child("goals").getValue().toString())
                            val currGroundBalls = Integer.parseInt(singlePlayerEntry.child("groundBalls").getValue().toString())
                            val currAssists = Integer.parseInt(singlePlayerEntry.child("assists").getValue().toString())
                            val currSaves = Integer.parseInt(singlePlayerEntry.child("saves").getValue().toString())
                            currPlayerList.add(Player(currFirstName, currLastName, currNumber, currGoals, currGroundBalls, currAssists, currSaves))
                        }
                        viewModel.addTeam(Team(currTeamName, currPlayerList))
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Log.w("WelcomeFragment", "Failed to read value.", error.toException())
            }
        })
        binding.getStartedButton.setOnClickListener {
            val action = WelcomeFragmentDirections.actionWelcomeFragmentToTeamFragment()
            binding.root.findNavController().navigate(action)
        }
        return rootView
    }

}