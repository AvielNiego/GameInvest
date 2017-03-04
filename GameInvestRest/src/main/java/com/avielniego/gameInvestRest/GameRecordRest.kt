package com.avielniego.gameInvestRest

import java.time.LocalDate

data class GameRecordRest(val date: LocalDate, val gambleSum: Double, val comment: String, val finishSum: Double?)