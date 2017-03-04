package com.avielniego.gamaRecordMongoDB

import java.time.LocalDate

data class GameRecordData(val _id: String?, val date: LocalDate, val gambleSum: Double, val comment: String, val finishSum: Double?)