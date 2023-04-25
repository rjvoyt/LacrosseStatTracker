package com.example.lacrossestattracker

import androidx.lifecycle.ViewModel


class LaxViewModel : ViewModel() {
    private lateinit var _teams: MutableList<Team>
    val teams: MutableList<Team>
        get() = _teams
    private lateinit var _currentTeam: Team
    val currentTeam: Team
        get() = _currentTeam
    private lateinit var _currentTeamName: String
    val currentTeamName: String
        get() = _currentTeamName
    private lateinit var _currentPlayerList: MutableList<Player>
    val currentPlayerList: MutableList<Player>
        get() = _currentPlayerList
    private lateinit var _currentPlayer: Player
    val currentPlayer: Player
        get() = _currentPlayer
    private var _currentPlayerFirstName = ""
    val currentPlayerFirstName: String
        get() = _currentPlayerFirstName
    private var _currentPlayerLastName = ""
    val currentPlayerLastName: String
        get() = _currentPlayerLastName
    private var _currentPlayerNumber = 0
    val currentPlayerNumber: Int
        get() = _currentPlayerNumber
    private var _currentPlayerGoals = 0
    val currentPlayerGoals: Int
        get() = _currentPlayerGoals
    private var _currentPlayerGroundBalls = 0
    val currentPlayerGroundBalls: Int
        get() = _currentPlayerGroundBalls
    private var _currentPlayerAssists = 0
    val currentPlayerAssists: Int
        get() = _currentPlayerAssists
    private var _currentPlayerSaves = 0
    val currentPlayerSaves: Int
        get() = _currentPlayerSaves
}