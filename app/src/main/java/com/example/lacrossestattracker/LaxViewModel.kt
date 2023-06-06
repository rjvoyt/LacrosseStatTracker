package com.example.lacrossestattracker

import androidx.lifecycle.ViewModel


class LaxViewModel : ViewModel() {
    private var _teams = mutableListOf<Team>()
    val teams: MutableList<Team>
        get() = _teams
    private lateinit var _currentTeam: Team
    val currentTeam: Team
        get() = _currentTeam
    val currentPlayerList: MutableList<Player>
        get() = _currentTeam.players
    private lateinit var _currentPlayer: Player
    val currentPlayer: Player
        get() = _currentPlayer
    val currentPlayerGoals: Int
        get() = _currentPlayer.goals
    val currentPlayerGroundBalls: Int
        get() = _currentPlayer.groundBalls
    val currentPlayerAssists: Int
        get() = _currentPlayer.assists
    val currentPlayerSaves: Int
        get() = _currentPlayer.saves
    fun addTeam(team: Team){
        _teams.add(team)
    }
    fun addPlayertoCurrentTeam(player: Player){
        _currentTeam.players.add(player)
    }
    fun editGoal(edit:Int){
        currentPlayer.goals+= edit
    }
    fun editAssist(edit:Int){
        currentPlayer.assists+= edit
    }
    fun editGroundBall(edit:Int){
        currentPlayer.groundBalls+= edit
    }
    fun editSave(edit:Int){
        currentPlayer.saves+= edit
    }
    fun setCurrentTeam(team: Team){
        _currentTeam = team
    }
    fun setCurrentPlayer(player: Player){
        _currentPlayer = player
    }
}