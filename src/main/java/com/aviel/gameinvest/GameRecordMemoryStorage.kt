package com.aviel.gameinvest

class GameRecordMemoryStorage : GameRecordGateaway {

    val games: MutableList<GameRecord> = mutableListOf()

    override fun addGameRecord(gameRecord: GameRecord) {
        games.add(gameRecord)
    }

    override fun deleteGameRecord(gameRecord: GameRecord) {
        games.remove(gameRecord)
    }

    override fun findAll(): List<GameRecord> {
        return games
    }

}