package com.example.dietplan.data.Model

data class WeekDietData(
    val monday: List<Monday>,
    val thursday: List<Thursday>,
    val wednesday: List<Wednesday>
)

interface WeekDays {

}