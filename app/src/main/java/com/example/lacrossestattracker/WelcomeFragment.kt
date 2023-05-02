package com.example.lacrossestattracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.lacrossestattracker.databinding.FragmentWelcomeBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


class WelcomeFragment : Fragment() {
    lateinit var dbRef : DatabaseReference
    private var _binding: FragmentWelcomeBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        val rootView = binding.root
        dbRef = Firebase.database.reference
        binding.getStartedButton.setOnClickListener{
            val action = WelcomeFragmentDirections.actionWelcomeFragmentToTeamFragment()
            binding.root.findNavController().navigate(action)
        }
        return rootView
    }

}