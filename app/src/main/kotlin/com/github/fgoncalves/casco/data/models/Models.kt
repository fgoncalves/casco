package com.github.fgoncalves.casco.data.models

data class Root(
    val colours: Map<String, String> = emptyMap(),
    val levels: List<Level> = emptyList())

data class Colour(val id: String = "", val name: String = "")

data class Exercise(
    val colours: List<Colour> = emptyList(),
    val correct: String = "")

data class Level(
    val exercises: List<Exercise> = emptyList(),
    val name: String = "",
    val speed: Int = 1,
    val description: String = "",
    val background: String = "")
