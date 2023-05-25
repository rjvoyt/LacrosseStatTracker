package com.example.lacrossestattracker

import androidx.lifecycle.ViewModel


class LaxViewModel : ViewModel() {
    private var _teams = mutableListOf<Team>()
    val teams: MutableList<Team>
        get() = _teams
    private var _currentTeamIndex = 0
    val currentTeamIndex: Int
        get() = _currentTeamIndex
    val currentTeamName: String
        get() = _teams[_currentTeamIndex].teamName
    val currentPlayerList: MutableList<Player>
        get() = _teams[_currentTeamIndex].players
    private lateinit var _currentPlayer: Player
    val currentPlayer: Player
        get() = _currentPlayer
    val currentPlayerFirstName: String
        get() = _currentPlayer.firstName
    val currentPlayerLastName: String
        get() = _currentPlayer.lastName
    val currentPlayerNumber: Int
        get() = _currentPlayer.number
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
        _teams[_currentTeamIndex].players.add(player)
    }
    fun editGoal(edit:Int){
        _teams[_currentTeamIndex].players[_teams[_currentTeamIndex].players.indexOf(_currentPlayer)].goals+= edit
    }
    fun editAssist(edit:Int){
        _teams[_currentTeamIndex].players[_teams[_currentTeamIndex].players.indexOf(_currentPlayer)].assists+= edit
    }
    fun editGroundBall(edit:Int){
        _teams[_currentTeamIndex].players[_teams[_currentTeamIndex].players.indexOf(_currentPlayer)].groundBalls+= edit
    }
    fun editSave(edit:Int){
        _teams[_currentTeamIndex].players[_teams[_currentTeamIndex].players.indexOf(_currentPlayer)].saves+= edit
    }
    fun setCurrentTeam(position:Int){
        _currentTeamIndex = position
    }
    fun setCurrentPlayer(player: Player){
        _currentPlayer = player
    }
}