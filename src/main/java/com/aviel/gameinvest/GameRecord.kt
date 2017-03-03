package com.aviel.gameinvest

import java.time.LocalDate

class GameRecord(val date: LocalDate, val gambleSum: Double, val comment: String = "") {
    var finishSum: Double? = null

    fun getRatio(): Double? {
        val finishSum = this.finishSum ?: return null
        return gambleSum / finishSum
    }
}