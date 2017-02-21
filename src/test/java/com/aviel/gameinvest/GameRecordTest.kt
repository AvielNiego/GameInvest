package com.aviel.gameinvest

import org.junit.Assert.*
import org.junit.Test
import java.time.LocalDate

class GameRecordTest{
    @Test
    fun createNew() {
        GameRecord("game1", LocalDate.now(), 100.0, 120.0)
    }
}