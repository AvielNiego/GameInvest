package com.aviel.gameinvest

interface GameRecordGateaway {
    fun addGameRecord(gameRecord: GameRecord)
    fun deleteGameRecord(gameRecord: GameRecord)
    fun findAll(): List<GameRecord>
}