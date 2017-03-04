package com.aviel.gameinvest.gameRecordGateaway

import com.aviel.gameinvest.GameRecord

interface GameRecordGateway {
    fun addGameRecord(gameRecord: GameRecord)
    fun deleteGameRecord(gameRecord: GameRecord)
    fun findAll(): List<GameRecord>
}