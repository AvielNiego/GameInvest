package com.avielniego.gameInvestRest

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate

@RestController
class GameRecordController {

    val gameRecord = GameRecordRest(LocalDate.now(), 100.0, "comment", 120.0)
    val records: MutableList<GameRecordRest> = mutableListOf(gameRecord)

    @RequestMapping("/game-records")
    fun findAll(): List<GameRecordRest> {
        return records
    }
}