package com.example.lacrossestattracker

data class Player(val firstName: String, val lastName: String, val number: Int, var goals: Int, var groundBalls: Int, var assists: Int, var saves: Int) {
}